package com.rizzi.angelo.casualbabo.characters;

import android.app.Activity;

import it.robertolaricchia.interfaces.CharacterInterface;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import dalvik.system.DexFile;

/**
 * Created by roberto on 08/12/15.
 */
public class CharacterFactory {

    Package aPackage;
    int count;

    private Activity parent;


    public CharacterFactory (Activity parent) {
        aPackage = Package.getPackage("com.rizzi.angelo.casualbabo.characters");
        //ClassLoader.getSystemClassLoader().
        count = CharacterInterface.class.getClasses().length;

        try {
            Method method = CharacterInterface.class.getMethod("costruisciStringa");
            //Class c = method.
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        this.parent = parent;
    }

    public int getCount () {
        //return getClassesForPackage(aPackage).size();
        return getClassesOfPackage("com.rizzi.angelo.casualbabo.characters").length;
    }

    private static Class<?> loadClass(String className) {
        try {
            return Class.forName(className);
        }
        catch (ClassNotFoundException e) {
            throw new RuntimeException("Unexpected ClassNotFoundException loading class '" + className + "'");
        }
    }

    public static List<Class<?>> processDirectory(File directory, String pkgname) {

        ArrayList<Class<?>> classes = new ArrayList<Class<?>>();

        //log("Reading Directory '" + directory + "'");

        // Get the list of the files contained in the package
        String[] files = directory.list();
        for (int i = 0; i < files.length; i++) {
            String fileName = files[i];
            String className = null;

            // we are only interested in .class files
            if (fileName.endsWith(".class")) {
                // removes the .class extension
                className = pkgname + '.' + fileName.substring(0, fileName.length() - 6);
            }

            //log("FileName '" + fileName + "'  =>  class '" + className + "'");

            if (className != null) {
                classes.add(loadClass(className));
            }

            //If the file is a directory recursively class this method.
            File subdir = new File(directory, fileName);
            if (subdir.isDirectory()) {
                classes.addAll(processDirectory(subdir, pkgname + '.' + fileName));
            }
        }
        return classes;
    }

    public static List<Class<?>> getClassesForPackage(Package pkg) {
        ArrayList<Class<?>> classes = new ArrayList<Class<?>>();

        //Get name of package and turn it to a relative path
        String pkgname = pkg.getName();
        String relPath = pkgname.replace('.', '/');

        // Get a File object for the package
        URL resource = ClassLoader.getSystemClassLoader().getResource(relPath);

        //If we can't find the resource we throw an exception
        if (resource == null) {
            throw new RuntimeException("Unexpected problem: No resource for " + relPath);
        }

        //log("Package: '" + pkgname + "' becomes Resource: '" + resource.toString() + "'");

        //If the resource is a jar get all classes from jar

        else {
            classes.addAll(processDirectory(new File(resource.getPath()), pkgname));
        }

        return classes;
    }

    private String[] getClassesOfPackage(String packageName) {
        ArrayList<String> classes = new ArrayList<String>();
        try {
            String packageCodePath = parent.getPackageCodePath();
            DexFile df = new DexFile(packageCodePath);
            for (Enumeration<String> iter = df.entries(); iter.hasMoreElements(); ) {
                String className = iter.nextElement();
                if (className.contains(packageName)) {
                    classes.add(className.substring(className.lastIndexOf(".") + 1, className.length()));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return classes.toArray(new String[classes.size()]);
    }

}

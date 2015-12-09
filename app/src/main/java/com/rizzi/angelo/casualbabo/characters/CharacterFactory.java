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
        count = CharacterInterface.class.getClasses().length;

        try {
            Method method = CharacterInterface.class.getMethod("costruisciStringa");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        this.parent = parent;
    }

    public int getCount () {
        return getClassesOfPackage("com.rizzi.angelo.casualbabo.characters").length;
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

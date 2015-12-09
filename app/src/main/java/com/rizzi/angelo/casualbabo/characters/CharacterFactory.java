package com.rizzi.angelo.casualbabo.characters;

import android.app.Activity;
import android.util.Log;

import it.robertolaricchia.interfaces.CharacterInterface;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import dalvik.system.DexFile;

/**
 * Created by roberto on 08/12/15.
 */
public class CharacterFactory {

    private static final String REF_PACKAGE = "com.rizzi.angelo.casualbabo.characters";

    private Activity parent;
    private HashSet<Class<? extends CharacterInterface>> characters = new HashSet<Class<? extends CharacterInterface>>();
    private Class<? extends CharacterInterface>[] character;

    public CharacterFactory (Activity parent) {

        this.parent = parent;

        String[] all = getClassesOfPackage(REF_PACKAGE);

        for ( int i=0; i<all.length; i++ ) {
            try {
                Class current = Class.forName(REF_PACKAGE + "." + all[i]);
                if (!current.isInterface()) {
                    try {
                        current.getMethod("costruisciStringa");
                        current.getMethod("getImageResource");
                        characters.add(current);
                        //Log.w("CharacterFactory", "Match found: " + all[i]);
                    } catch (NoSuchMethodException e) {
                        //Log.e("CharacterFactory", "no such method: "+all[i]);
                    }
                }
            } catch (ClassNotFoundException e) {
                Log.e("CharacterFactory", "class not found: "+REF_PACKAGE + "." + all[i]);
            }
        }

        buildCharacterArray();

    }

    public int getCount () {
        return character.length;
    }

    public CharacterInterface getCharacter ( int index ) throws ArrayIndexOutOfBoundsException, IllegalAccessException, InstantiationException {
        if ( index > getCount()-1 ) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return character[index].newInstance();
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

        return classes.toArray( new String[classes.size()] );
    }

    private void buildCharacterArray () {
        character = new Class[characters.size()];
        character = characters.toArray(character);
    }

}

package com.rizzi.angelo.casualbabo.characters;

import com.rizzi.angelo.casualbabo.interfaces.CharacterInterface;

import java.lang.reflect.Method;

/**
 * Created by roberto on 08/12/15.
 */
public class CharacterFactory {

    Package aPackage;
    int count;

    public CharacterFactory () {
        aPackage = Package.getPackage("com.rizzi.angelo.casualbabo.characters");
        //ClassLoader.getSystemClassLoader().
        count = CharacterInterface.class.getClasses().length;

        try {
            Method method = CharacterInterface.class.getMethod("costruisciStringa");
            //Class c = method.
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public int getCount () {
        return count;
    }

}

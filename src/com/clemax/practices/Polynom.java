package com.clemax.practices;

import com.clemax.OStack;
import java.util.Locale;

public class Polynom {
    public static void main(String[] args) {
        System.out.println(isPolynom("Lagerregal"));
    }

    public static boolean isPolynom(String content) {
        content = content.toLowerCase(Locale.ROOT);

        OStack<Character> characterStack = new OStack<>();

        for (int i = 0; i < content.length(); i++)
            characterStack.push(content.charAt(i));

        int j = 0;
        while (!characterStack.isEmpty()) {
            if (!(characterStack.top() == content.charAt(j)))
                return false;

            characterStack.pop();
            j++;
        }

        return true;
    }
}

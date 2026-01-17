public class Graphics {

    static String getGraphics(int type){
        switch (type){
            case Fighter.WIZARD:
                return wizard;
            case Fighter.DRAGON:
                return dragon;
            case Fighter.OGRE:
                return ogre;
            case Fighter.HYDRA:
                return hydra;
            case Fighter.DEMON:
                return demon;
        }
        return "Error";
    }

    static final String dragon =
                    " <>=======() \n" +
                    "(/\\___   /|\\\\          ()==========<>_\n" +
                    "      \\_/ | \\\\        //|\\   ______/ \\)\n" +
                    "        \\_|  \\\\      // | \\_/\n" +
                    "          \\|\\/|\\_   //  /\\/\n" +
                    "           (oo)\\ \\_//  /\n" +
                    "          //_ /\\_\\/ /  |\n" +
                    "         @@/  |=\\  \\  |\n" +
                    "              \\_=\\_ \\ |\n" +
                    "                \\==\\ \\|\\_\n" +
                    "             __(\\===\\(  )\\\n" +
                    "            (((~) __(_/   |\n" +
                    "                 (((~) \\  /\n" +
                    "                 ______/ /\n" +
                    "                 '------'\n";

    static final String demon =
                    "          .    .\n" +
                    "          |\\   |\\\n" +
                    "       _..;|;__;|;\n" +
                    "     ,'   ';` \\';`-.\n" +
                    "     7;-..     :   )\n" +
                    ".--._)|   `;==,|,=='\n" +
                    " `\\`@; \\_ `<`G,\" G).\n" +
                    "   `\\/ -;,(  )  .>. )\n" +
                    "       < ,-;'-.__.;'\n" +
                    "        `\\_ `-,__,'\n" +
                    "           `-..,;,>\n" +
                    "              `;;;`\n";

    static final String ogre =
                    "      _____\n" +
                    "     /     \\\n" +
                    "    /  _ _  \\\n" +
                    "   /  /   \\  \\\n" +
                    "  |   o o   |\n" +
                    "  |    ^    |\n" +
                    "  |  \\___/  |\n" +
                    "   \\_____/\n" +
                    "  /  /   \\  \\\n" +
                    " /__/     \\__\\\n" +
                    " |  |     |  |\n" +
                    " |  |     |  |\n" +
                    " |__|_____|__|\n" +
                    "  /_/     \\_\\\n" +
                    "    \\_____/\n";

    static final String hydra =
                    "            /^\\/^\\\n" +
                    "          _|__|  O|\n" +
                    " \\/     /~     \\_/ \\\n" +
                    "  \\____|__________/  \\\n" +
                    "         \\_______      \\\n" +
                    "                 `\\     \\\n" +
                    "                   |     |\n" +
                    "                  /      /\n" +
                    "                 /     /\n";

    static final String wizard =
                    "                  /\\\n" +
                    "                 /  \\\n" +
                    "                |    |\n" +
                    "              --:'''':--\n" +
                    "                :'_' :\n" +
                    "                _:\"\":\\___\n" +
                    " ' '      ____.' :::     '._\n" +
                    ". *=====<<=)           \\    :\n" +
                    "            .  '      '-'-'\\_      /'._.'\n" +
                    "                  \\====:_ \"\"\n" +
                    "                 .'     \\\\\n" +
                    "                :       :\n" +
                    "               /   :    \\\n" +
                    "              :   .      '.\n" +
                    "              :  : :      :\n" +
                    "              :__:-:__.;--'\n" +
                    "              '-'   '-'\n";

}
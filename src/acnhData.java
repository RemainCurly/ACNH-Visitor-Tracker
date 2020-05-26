public class acnhData
{
   //If anything changes in-game, edit lines 6-7, 9 & 12, and line 10 & 13 comments only (as well as whatever errors may happen)
   public static final int GUARANTEE_LENGTH = 3;
   public static final int CHANCE_LENGTH = 5;
   
   public static String[] guaranteers = {"Kicks", "Leif", "Saharah"};
   //0 = Kicks, 1 = Leif, 2 = Saharah
   public static boolean[] guaranteerVisited = new boolean[GUARANTEE_LENGTH];
   public static String[] chancers = {"CJ", "Flick", "Gulliver", "Label", "Redd"};
   //0 = CJ, 1 = Flick, 2 = Gulliver, 3 = Label, 4 = Redd
   public static boolean[] chancerVisited = new boolean[CHANCE_LENGTH];
   public static boolean[] isPriority = new boolean[CHANCE_LENGTH];
}
public class Main {
    public static void main(String[] args) {

        String a = "\033[31m";
        String b = "\033[32m";
        String c = "\033[33m";
        String d = "\033[34m";
        String e = "\033[35m";
        String f = "\033[37m";

        String FOL = a + "FOL";
        String LMSGI = b + "LMSGI";
        String PROG = c + "PROG";
        String SI = d + "SI";
        String ED = e + "ED";
        String BD = f + "BD";

        System.out.println("Horas \t\t\t Lunes \t\t Martes \t Miércoles \t\t Jueves \t\t Viernes");
        System.out.println("4:30-5:30 \t\t "+FOL+"\t\t "+SI+"\t\t\t "+ED+"\t\t\t\t "+PROG+"\t\t\t "+PROG);
        System.out.println("5:30-6:30 \t\t " + LMSGI + " \t\t " +SI+ "\t\t\t " + ED + "\t\t\t\t " + PROG + "\t\t\t " + PROG);
        System.out.println("6:30-8:30 \t\t " + LMSGI + " \t\t " + SI + " \t\t " + ED + " \t\t\t " + FOL + " \t\t\t " + PROG);
        System.out.println("7:30-8:30 \t\t " + PROG + " \t\t " + LMSGI + " \t\t " + BD + " \t\t\t " + SI + " \t\t\t " + BD);
        System.out.println("8:30-9:30 \t\t " + PROG + " \t\t " + LMSGI + " \t\t " + BD + " \t\t\t " + SI + " \t\t\t " + BD);
        System.out.println("9:30-10:30 \t\t " + PROG + " \t\t " + FOL + " \t\t " + BD + "\t\t\t\t " + SI + "\t\t\t\t " + BD);
    }
}
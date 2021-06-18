public class FirstBank {
    public static void main(String[] args) {

        Account michael = new Account("Michael", "M00002");
        michael.showMenu();
        michael.deposit(20);
    }
}

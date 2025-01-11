import java.util.*;
class BankManagement{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String accountname = null;
        String password = null;
        boolean accountcreated = false;
        double balance = 0.0;
        double wallet = 300.0;
        boolean e = true;
        System.out.println("Welcome to the bank! What would you like to do?");
        while (e==true) {
            System.out.println("1. Create an account");
            System.out.println("2. Deposit or withdraw money");
            System.out.println("3. Edit account details");
            System.out.println("4. Check balance");
            System.out.println("5. Exit");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    if (accountcreated == true) {
                        System.out.println("An account is already created.");
                    } else {
                        System.out.println("What would you like to name your account?");
                        accountname = sc.nextLine();
                        System.out.println("Great " + accountname + ", now set a password.");
                        password = sc.nextLine();
                        System.out.println("Your name is " + accountname + ", and your password is " + password + ". Press 1 to confirm account creation, 2 to cancel.");
                        int confirm = sc.nextInt();
                        if (confirm == 1) {
                            System.out.println("Account has been created.");
                            accountcreated = true;
                        } else if (confirm == 2) {
                            System.out.println("Going back to the menu.");
                             accountname = null;
                             password = null;
                             accountcreated = false;

                        } else {
                            System.out.println("Error");
                        }



                    }
                    break;
                case 2:
                    if (accountcreated == true){
                        System.out.println("What is your account name?");
                        String namecheck = sc.nextLine();
                        if(namecheck.equals(accountname)){
                            System.out.println("What is your password?");
                            String passcheck = sc.nextLine();
                            if(passcheck.equals(password)) {
                                System.out.println("Would you like to withdraw or deposit? 1 for withdraw, 2 for deposit");
                                int depositorwithdraw = sc.nextInt();
                                sc.nextLine();
                                if (depositorwithdraw == 1) {
                                    System.out.println("How much you would like to withdraw?");
                                    double amountwithdrawed = sc.nextDouble();
                                    sc.nextLine();
                                    if (amountwithdrawed > balance) {
                                        System.out.println("You do not have enough money to withdraw that much.");

                                    } else if (amountwithdrawed <= balance) {
                                        balance = balance - amountwithdrawed;
                                        wallet = amountwithdrawed + wallet;
                                        System.out.println(amountwithdrawed + "$ has been withdrawed. You have " + balance + "$ in your bank account, and " + wallet + " in your wallet. Thank you for using Chingo Bank.");
                                        System.out.println("Press 1 to back to menu");

                                    }
                                }
                                if (depositorwithdraw == 2) {
                                    System.out.println("How much would you like to deposit?");
                                    double amountdeposited = sc.nextDouble();
                                    sc.nextLine();
                                    if (amountdeposited > wallet) {
                                        System.out.println("You do not have that much money.");
                                    } else if (amountdeposited <= wallet) {
                                        balance = balance + amountdeposited;
                                        wallet = wallet - amountdeposited;
                                        System.out.println(amountdeposited + "$ has been deposited. You have " + balance + "$ in your bank account, and " + wallet + "$ in your wallet.");
                                    }

                                }
                            } else{
                                System.out.println("Password is wrong. Try again later.");
                            }


                        } else {
                            System.out.println("Account has not been found. Try later.");
                        }


                    } else {
                        System.out.println("Account has not been created. Please make an account before trying to withdraw/deposit.");
                    }

                    break;
                case 3:
                    if(accountcreated==false){
                        System.out.println("You have not created an account. Please create an account before trying to edit your account details.");
                    } else if(accountcreated==true){
                        System.out.println("Choose one of the options below.");
                        System.out.println("1. Change account name");
                        System.out.println("2. Change account password");
                        System.out.println("3. Back to menu");
                        int accountchoice = sc.nextInt();
                        sc.nextLine();
                        switch(accountchoice){
                            case 1:
                                System.out.println("Enter your current account name to change your account name.");
                                String changename = sc.nextLine();
                                if(changename.equals(accountname)){
                                    System.out.println("Now enter your current password.");
                                    String detailspass = sc.nextLine();
                                    if(detailspass.equals(password)){
                                        System.out.println("Account has been found and verified. Please enter your new account name");
                                        accountname= sc.nextLine();
                                        System.out.println("Account name has been changed to "+accountname+". Thank you for using Chingo Bank.");
                                        break;
                                    } else if (!(detailspass.equals(password))){
                                        System.out.println("Wrong password. Try again later.");
                                    }

                                } else if(!(changename.equals(accountname))){
                                    System.out.println("Wrong account name. Account has not been found. Try again later.");
                                }
                                break;
                            case 2:
                                System.out.println("To change your password, you must enter your account name below first.");
                                String passname = sc.nextLine();
                                if(passname.equals(accountname)){
                                    System.out.println("Now enter your current password.");
                                    String detailspass = sc.nextLine();
                                    if(detailspass.equals(password)){
                                        System.out.println("Account has been found and verified. Please enter your password");
                                        password= sc.nextLine();
                                        System.out.println("Account password has been changed to "+password+". Thank you for using Chingo Bank.");
                                        break;
                                    } else if (!(detailspass.equals(password))){
                                        System.out.println("Wrong password. Try again later.");
                                    }

                                } else if(!(passname.equals(accountname))){
                                    System.out.println("Wrong account name. Account has not been found. Try again later.");
                                }
                                break;
                            case 3:
                                System.out.println("Going back to menu...");
                        break;
                        }

                    }
                    break;
                case 4:
                    if (accountcreated == true) {
                        System.out.println("What is your account name?");
                        String ncheck = sc.nextLine();
                        if (ncheck.equals(accountname)) {
                            System.out.println("What is your password?");
                            String pcheck = sc.nextLine();
                            if (pcheck.equals(password)) {
                                System.out.println("You currently have $"+balance+" in your bank account.");
                                System.out.println("Press 1 to go back to menu.");
                                int fourmenu = sc.nextInt();
                                sc.nextLine();
                                if(fourmenu==1){
                                    break;
                                }

                            }
                        }
                    } else if(accountcreated==false){
                        System.out.println("Please create an account before trying to check your balance.");
                        break;
                    }

                case 5:
                    System.out.println("Exited.");
                    e=false;
                    break;

            }


           }

        }




    }

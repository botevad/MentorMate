public class Child extends Person{
    public Child(String name, String sex, String language, String religion, String job, String nationality, String pin, String countryOfResidence) {
        super(name, sex, language, religion, null, nationality, pin, countryOfResidence);
    }

    @Override
    public boolean isAdult() {
        System.out.printf("%s is a child. \n", getName());
        return false;
    }

    @Override
    public boolean canTakeLoan() {
        System.out.printf("%s can't take a loan. \n", getName());
        return false;
    }

    public void play(){
        System.out.printf("%s plays games and has fun! \n", getName());

    }
}

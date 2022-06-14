public class Bulgarian extends Person{
    public Bulgarian(String name, String sex, String language, String religion, String job, String nationality, String pin, String countryOfResidence) {
        super(name, sex, "Bulgarian", religion, job, "Bulgarian", pin, countryOfResidence);
    }

    public void drinks(){
        if (isAdult()) {
            System.out.printf("%s drinks Rakia!\n", getName());
        }else {
            System.out.printf("%s drinks milk!\n", getName());
        }
    }

    @Override
    public void sayHello() {
        System.out.printf("Здравей, аз се казвам %s\n", getName());
    }

    @Override
    public boolean isAdult() {
        if (getAge() >= 18){
            System.out.printf("%s is Adult.\n", getName());
            return true;
        } else {
            System.out.printf("%s is NOT Adult.\n", getName());
            return false;
        }
    }
}

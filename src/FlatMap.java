import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FlatMap {

    public static void main(String[] args) {
        // streams using filter and for each
        List<User> users = Arrays.asList(
                new User("jags", 20, Arrays.asList("1", "2")),
                new User("kitty", 30, Arrays.asList("3", "4")),
                new User("Mohan", 25, Arrays.asList("5", "6")),
                new User("Reddy", 22, Arrays.asList("7", "8"))
        );
        System.out.println("Functional programming");

        //flatMap usage
        Optional<String> stringOptional = users.stream()
                .map(user -> user.getPhoneNumbers().stream())
                .flatMap(stringStream -> stringStream.filter(phoneNo -> phoneNo.equals("5")))
                .findAny();
        stringOptional.ifPresent(System.out::println);



    }




    // Mapper
    static class User{
        private String name;
        private int age =30;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public List<String> getPhoneNumbers() {
            return phoneNumbers;
        }

        public void setPhoneNumbers(List<String> phoneNumbers) {
            this.phoneNumbers = phoneNumbers;
        }

        private List<String> phoneNumbers;


        public User(String name, int age, List<String> phoneNumbers) {
            this.name = name;
            this.age = age;
            this.phoneNumbers = phoneNumbers;
        }

        @Override
        public String toString(){
            return "name:"+name;
        }





}}

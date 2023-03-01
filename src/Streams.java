import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Streams {

    public static void main(String[] args) {
        // streams using filter and for each
        List<String> names = Arrays.asList("Jags", "Reddy", "Kittu", "Mohan");
        //imperative style
        System.out.println("Imperative style");
        for (String name : names) {
            if(!name.equals("Jags")){
                Mapper mapper = new Mapper(name);
                System.out.println(mapper);
            }
        }
        System.out.println("Functional type");
        //streams functional programing style
        //Map
        names.stream()
                .filter(Streams::isNotJags)   //method reference
                .map(Mapper::new)// map one object to other
                .forEach(System.out::println);  //terminal operation
        //collect
        List<Mapper> mapperList = names.stream()
                .filter(Streams::isNotJags)   //method reference
                .map(Mapper::new)// map one object to other
                .collect(Collectors.toList());//terminal operation instead of printing it will accumulate values
        System.out.println(mapperList);
        for (Mapper mapper : mapperList) {
            System.out.println(mapper);
        }

        //MapToInt
        int sum = mapperList.stream()
                .mapToInt(Mapper::getAge)
                .sum();
        System.out.println(sum);

        //FlatMaps


    }


    private static boolean isNotJags(String name) {
        return !name.equals("Jags");
    }

    // Mapper
    static class Mapper{
        private String name;
        private int age =30;

        public Mapper(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }


        @Override
        public String toString(){
            return "name:"+name;
        }
    }


}
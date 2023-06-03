package arrays.BasicAlgorithms.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

/*
 * return duplicates of Given array 
 * we can use Function.Identity instead of emp->emp
 */
class findDuplicatesUsingCounting {
    public static void main(String[] args) {
        List<String> arr = new ArrayList<>(Arrays.asList("vijay", "vijay", "vijay", "surya", "mohit", "surya"));
        Map<String, Long> mapOfNames = arr.stream().collect(Collectors.groupingBy(emp -> emp, Collectors.counting()));
        System.out.println("Map with frequency :" + mapOfNames.toString());
        Set<String> duplicates = mapOfNames.entrySet().stream().filter(entry -> entry.getValue() > 1)
                .map(entry -> entry.getKey()).collect(Collectors.toSet());
        System.out.println("duplicated names :" + duplicates.toString());

    }
}

/*
 * Using collections.frequency
 */
class findDuplicatesUsingFrequency {
    public static void main(String[] args) {
        List<String> arr = new ArrayList<>(Arrays.asList("vijay", "vijay", "vijay", "surya", "mohit", "surya"));
        Set<String> duplicates = arr.stream().filter(name -> Collections.frequency(arr, name) > 1)
                .collect(Collectors.toSet());
        System.out.println("Duplicates Using frequency" + duplicates.toString());
        System.out.println(Collections.frequency(arr, "vijay"));
    }
}

/*
 * Create employee map sort as tree map
 * sorted tree map 3 parameter group
 */
class groupByEmployeeAge {
    public static void main(String[] args) {
        List<Employee> employees = createEmployeesList();
        Map<Integer, Set<Employee>> empMap = employees.stream()
                .collect(Collectors.groupingBy(emp -> emp.getAge(), TreeMap::new, Collectors.toSet()));
        System.out.println("employess sorted grouped by age :" + empMap.toString());

    }

    private static List<Employee> createEmployeesList() {
        Employee emp1 = new Employee();
        emp1.setName("Vijay");
        emp1.setAge(10);
        Employee emp2 = new Employee();
        emp2.setName("Vijay");
        emp2.setAge(15);
        Employee emp3 = new Employee();
        emp3.setName("Vijay");
        emp3.setAge(12);
        Employee emp4 = new Employee();
        emp4.setName("surya");
        emp4.setAge(18);
        Employee emp5 = new Employee();
        emp5.setName("mohit");
        emp5.setAge(12);
        Employee emp6 = new Employee();
        emp6.setName("mohit");
        emp6.setAge(12);
        Employee emp7 = new Employee();
        emp7.setName("mohit");
        emp7.setAge(12);
        List<Employee> employees = new ArrayList<>(Arrays.asList(emp1, emp2, emp3, emp4, emp5, emp6));
        return employees;
    }
}

class Employee {
    int id;
    String name;
    int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    @Override
    public String toString() {
        return "Employee [name=" + name + ", age=" + age + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + age;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Employee other = (Employee) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (age != other.age)
            return false;
        return true;
    }

}

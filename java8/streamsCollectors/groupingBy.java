package java8.streamsCollectors;

import java.util.List;
import java.util.stream.Collectors;

class groupingBy {
    /*
     * seggregate wrt age
     */
    public void groupBy() {
        // List<Employee> empList=repo.findAll().stream().collect(Collectors.toList());
        // Map<Integer,List<Employee>>
        // empList=repo.findAll().stream().collect(Collectors.groupingBy(emp->emp.getAge()));
        //
    }

    /*
     * Returns : name with occurances
     * Grouping collector
     * --- classification function which is an instance of function f<T,K>
     * T - type of object in stream
     * K are the group names or group keys
     * Map<K, Collection<T>>
     * If name is same then the employee is same then what?
     * 
     */
    public void groupByIdentity() {
        // List<String>
        // namesRepo=repo.findAll().stream().map(emp->emp.getName()).collect(Collectors.toList());

        // Map<Integer,Long>
        // mapOfNames=namesRepo.stream().collect(Collectors.groupingBy(Function.identity(),
        // Collectors.counting()));

        // set<String> names= mapOfNames.entrySet().stream().filter(entry ->
        // entry.getValue()>1).map(entry->entry.getKey()).collect(Collector.toList())
    }

    public void usingCollectionFrequency() {
        // List<String>
        // namesRepo=repo.findAll().stream().map(emp->emp.getName()).collect(Collectors.toList());

        // namesRepo.stream().filter(name ->
        // Collections.frequency(nameRepo,name)>1).collect(Collectors.toSet())
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
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
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
        return true;
    }

}
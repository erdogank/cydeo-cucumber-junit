package com.cydeo.step_definitions;

import io.cucumber.java.en.Then;

import java.util.List;
import java.util.Map;

public class DataTables_StepDefinitions {

    @Then("user should see fruits I like")
    public void user_should_see_fruits_i_like(Map<String,Integer> fruits) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        System.out.println("fruits I like: "+fruits);
        System.out.println(fruits.get("kiwi"));
    }

}

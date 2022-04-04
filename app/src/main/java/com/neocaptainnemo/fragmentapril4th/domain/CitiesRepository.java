package com.neocaptainnemo.fragmentapril4th.domain;

import java.util.List;

public interface CitiesRepository {

    List<City> getAll();

    void add(City city);
}

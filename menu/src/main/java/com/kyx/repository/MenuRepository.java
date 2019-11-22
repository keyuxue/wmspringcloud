package com.kyx.repository;

import com.kyx.entity.Menu;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
public interface MenuRepository {
    public List<Menu> findAll(int index,int limit);

    public int count();

    public Menu findById(long id);

    public void save();

    public void update();

    public void deleteById();
}

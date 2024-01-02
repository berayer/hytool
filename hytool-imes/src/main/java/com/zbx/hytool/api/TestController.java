package com.zbx.hytool.api;

import com.zbx.hytool.entity.SearchFilter;
import com.zbx.hytool.service.SearchFilterService;
import com.zbx.hytool.util.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final SearchFilterService searchFilterService;

    @GetMapping("/order/{id}")
    public Result test(@PathVariable("id") Integer id) {
        SearchFilter searchFilter = searchFilterService.getByRefId(id, 2);
        return Result.data(searchFilter);
    }

}

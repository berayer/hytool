package com.zbx.hytool.service;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zbx.hytool.entity.SearchFilter;
import com.zbx.hytool.mapper.SearchFilterMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchFilterService {

    private final SearchFilterMapper searchFilterMapper;

    public SearchFilter getByRefId(Integer refId, Integer type) {
        SearchFilter searchFilter = searchFilterMapper.selectOne(new LambdaQueryWrapper<SearchFilter>()
                .eq(SearchFilter::getRefId, refId)
                .eq(SearchFilter::getSearchFilterType, type)
                .isNull(SearchFilter::getParentId));
        this.fillChildren(searchFilter);
        return searchFilter;
    }

    private void fillChildren(SearchFilter sf) {
        List<SearchFilter> children = searchFilterMapper.selectList(new LambdaQueryWrapper<SearchFilter>()
                .eq(SearchFilter::getParentId, sf.getId())
                .eq(SearchFilter::getSearchFilterType, sf.getSearchFilterType()));
        if (CollectionUtil.isNotEmpty(children)) {
            children.forEach(this::fillChildren);
            sf.setChildren(children);
        }
    }
}

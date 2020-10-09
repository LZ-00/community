package com.community.dto;

import com.community.entity.Question;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.sql.In;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Pagination {
    private List<Question> questions;
    private boolean hasPrevious;
    private boolean hasFirst;
    private boolean hasNext;
    private boolean hasEnd;
    private Integer page;
    private Integer totalPage;
    private Integer totalCount;
    private final Integer maxHalfSize = 3;
    private List<Integer> pages;


    public void setPagination(Integer page, Integer size, Integer totalCount) {
        this.page = page;
        pages = new ArrayList<>();
        totalPage = (totalCount%size) == 0 ? totalCount/size : totalCount/size+1;

        page = page<1 ? 1 : page;
        page = page>totalPage ? totalPage:page;


        pages.add(page);
        for(int i=1;i<=maxHalfSize;i++){
            if(page-i>0){
                pages.add(0,page-i);
            }
            if(page+i<=totalPage){
                pages.add(page+i);
            }
        }

        hasPrevious = page != 1;
        hasNext = !page.equals(totalPage);

        hasFirst = !pages.contains(1);
        hasEnd = !pages.contains(totalPage);


    }
}

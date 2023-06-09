package io.dustin.apps.common.model;

import lombok.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

@ToString
@Data
public class QueryPage {

    private int page;
    private int size;

    private String column;

    private Sort.Direction sort;

    public int offset() {
        System.out.println(this.page);
        // TODO page 음수인 경우 또는 0 경우 처리
        return this.page - 1;
    }

    public int limit() {
        return this.size;
    }

    public PageRequest pageable() {
        Sort sort = Sort.unsorted();
        if(column != null && sort != null) {
            sort = Sort.by(this.sort, column);
        }
        return PageRequest.of(offset(), limit(), sort);
    }

}

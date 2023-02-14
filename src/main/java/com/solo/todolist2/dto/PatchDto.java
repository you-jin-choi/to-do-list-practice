package com.solo.todolist2.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatchDto {
    private Long id;
    private String title;
    private Long todo_order;
    private boolean completed;
}

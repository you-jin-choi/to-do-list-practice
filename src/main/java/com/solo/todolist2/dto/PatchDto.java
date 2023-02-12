package com.solo.todolist2.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatchDto {
    private int id;
    private String title;
    private int todo_order;
    private boolean completed;
}

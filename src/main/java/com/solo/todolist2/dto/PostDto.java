package com.solo.todolist2.dto;

import lombok.Getter;

@Getter
public class PostDto {
    private String title;
    private int todo_order;
    private boolean completed;
}

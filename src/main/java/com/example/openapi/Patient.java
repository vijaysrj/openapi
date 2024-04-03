package com.example.openapi;

import java.util.Date;

public record Patient(String id,String name,String disease,String prescription, Date firstVisit,Date lastVisit) {
    
}

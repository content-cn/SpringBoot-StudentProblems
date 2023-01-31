package com.example.airtel1.repository;

import java.util.Optional;

public interface DAO<T> {
    int save(T t);
}

package org.nix.book.dao.repositories;

import org.nix.book.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookReposition extends JpaRepository<UserModel,Integer> {
}

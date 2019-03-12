package de.budget.project.repository;

import de.budget.project.model.user.User;
import de.budget.project.model.wallet.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet, Long> {

    Wallet findWalletById(Long walletId);

    Wallet findWalletByUserId(User user);

//        @Query("SELECT new de.budget.project.model.user.UserInfoWebResponse" +
//               "(w.userId.userName, w.userId.email, w.balance, w.currency )" +
//                "FROM Wallet w WHERE w.userId.email =:email")
//        UserInfoWebResponse getUserInfoByEmail(@Param("email") String email);
}
package com.example.Ewallet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletService {

    @Autowired
    WalletRepository walletRepository;

    public void createWallet(String userName, String password) throws UserAlreadyExistsException {
        Wallet userExisting = walletRepository.findByUserName(userName);
        if (userExisting != null) {
            throw new UserAlreadyExistsException("Username already exists...!!");
        }

        Wallet wallet=Wallet.builder()
         .userName(userName)
         .password(password)
         .amount(0)
          .build();
        walletRepository.save(wallet);

    }

   public Wallet addAmount(WalletEntryDto walletEntryDto) throws UserNotFoundException {
       Wallet newWallet;
       Wallet userExists = walletRepository.findByUserName(walletEntryDto.getUserName());
       //System.out.println( walletEntryDto.getAmount());
       //System.out.println(userExists.getAmount());
      if (userExists == null)
          throw new UserNotFoundException("User Not Found..!!");

      if (!walletEntryDto.getPassword().equals(userExists.getPassword())) {
           throw new UserNotFoundException("Invalid password...!");
       }
       else {
           int newAmount = userExists.getAmount() + walletEntryDto.getAmount();

          // System.out.println(newAmount + " "+ walletEntryDto.getAmount());
           newWallet = Wallet.builder()
                   .id(userExists.getId())
                   .amount(newAmount)
                   .userName(walletEntryDto.getUserName())
                   .password(walletEntryDto.getPassword())
                   .build();
          newWallet=walletRepository.save(newWallet);
       }
       return newWallet;
   }

}

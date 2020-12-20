package wallet

import (
	"testing"
	"lib"
)

func TestWallet(t *testing.T) {
	t.Run("add money to wallet", func(t *testing.T) {
		wallet := Wallet{}
		wallet.Deposit(Bitcoin(10))
		lib.AssertEqual(t, wallet.Balance(), Bitcoin(10))
	})
	t.Run("take money out of the wallet", func(t *testing.T) {
		wallet := Wallet{}
		wallet.Deposit(Bitcoin(40))
		lib.AssertEqual(t, wallet.Balance(), Bitcoin(40))
		withdraw := wallet.Withdraw(20)
		lib.AssertEquals(t, withdraw, nil)
		lib.AssertEqual(t, wallet.Balance(), Bitcoin(20))
	})
	t.Run("take more money out than present", func(t *testing.T) {
		wallet := Wallet{}
		wallet.Deposit(Bitcoin(40))
		lib.AssertEqual(t, wallet.Balance(), Bitcoin(40))
		withdraw := wallet.Withdraw(50)
		lib.AssertEquals(t, withdraw, ErrInsufficientFunds)
		lib.AssertEqual(t, wallet.Balance(), Bitcoin(40))
	})
}

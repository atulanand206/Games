package wallet

import (
	"fmt"
	"errors"
)

type Stringer interface {
	String() string
}

type Bitcoin float64

func (bitcoin Bitcoin) String() string {
	return fmt.Sprintf("%f BTC", bitcoin)
}

type Wallet struct {
	balance Bitcoin
}

func (wallet *Wallet) Deposit(amount Bitcoin) {
	wallet.balance += amount
}

var ErrInsufficientFunds = errors.New("insufficient funds")

func (wallet *Wallet) Withdraw(amount Bitcoin) error {
	if wallet.balance < amount {
		return ErrInsufficientFunds
	}
	wallet.balance -= amount
	return nil
}

func (wallet *Wallet) Balance() Bitcoin {
	return wallet.balance
}

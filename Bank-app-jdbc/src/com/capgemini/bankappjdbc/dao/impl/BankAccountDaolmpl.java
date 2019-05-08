package com.capgemini.bankappjdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.capgemini.bankappjdbc.dao.BankAccountDao;
import com.capgemini.bankappjdbc.model.BankAccount;
import com.capgemini.bankappjdbc.util.DbUtil;

public class BankAccountDaolmpl implements BankAccountDao {

	@Override
	public double getBalance(long accountId) {
		String query = "SELECT account_balance FROM bankaccount WHERE account_id = " + accountId;
		double balance = -1;
		Connection connection = DbUtil.getConnection();
		try (PreparedStatement statement = connection.prepareStatement(query);
				ResultSet result = statement.executeQuery()) {

			result.next();
			balance = result.getDouble(1);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return balance;
	}

	@Override
	public void updateBalance(long accountId, double newBalance) {
		String query = "UPDATE bankaccount SET account_balance =? WHERE account_id = ? ";
		Connection connection = DbUtil.getConnection();
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setDouble(1, newBalance);
			statement.setLong(2, accountId);

			int result = statement.executeUpdate();
			System.out.println("No. of rows updated" + result);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public boolean deleteBankAccount(long accountId) {
		String query = "DELETE FROM bankaccount WHERE account_id = " + accountId;
		int result;
		Connection connection = DbUtil.getConnection();
		try (PreparedStatement statement = connection.prepareStatement(query)) {

			result = statement.executeUpdate();
			if (result == 1) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean addNewBankAccount(BankAccount account) {
		String query = "INSERT INTO bankaccount(customer_name, account_type, account_balance) VALUES (?,?,?)";
		Connection connection = DbUtil.getConnection();
		try (PreparedStatement statement = connection.prepareStatement(query)) {

			statement.setString(1, account.getAccoundHolderName());
			statement.setString(2, account.getAccountType());
			statement.setDouble(3, account.getAccountBalance());

			int result = statement.executeUpdate();
			if (result == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<BankAccount> findAllBankAccount() {
		String query = "SELECT * FROM bankaccount";
		List<BankAccount> bankAccount = new ArrayList<BankAccount>();
		Connection connection = DbUtil.getConnection();
		try (PreparedStatement statement = connection.prepareStatement(query)) {

			ResultSet result = statement.executeQuery();
			{

				while (result.next()) {
					long accountId = result.getLong(1);
					String accountHolderName = result.getString(2);
					String accountType = result.getString(3);
					double accountBalance = result.getDouble(4);
					BankAccount account = new BankAccount(accountId, accountHolderName, accountType, accountBalance);
					bankAccount.add(account);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bankAccount;
	}

	@Override
	public BankAccount searchAccount(long accountId) {
		BankAccount account = null;
		String query = "SELECT * FROM bankaccount WHERE account_id = " + accountId;
		Connection connection = DbUtil.getConnection();
		try (PreparedStatement statement = connection.prepareStatement(query);) {
			
			ResultSet result = statement.executeQuery();
			result.next();
			long AccountId = result.getLong(1);
			String accountHolderName = result.getString(2);
			String accountType = result.getString(3);
			double accountBalance = result.getDouble(4);
			account = new BankAccount(accountId, accountHolderName, accountType, accountBalance);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return account;
	}

	@Override
	public boolean updateAccount(long accountId, String accountHolderName, String accountType) {
		String query = "UPDATE bankaccount SET customer_name = ? , account_type = ? WHERE account_id =" + accountId;
		Connection connection = DbUtil.getConnection();
		try (PreparedStatement statement = connection.prepareStatement(query)) {

			statement.setString(1, accountHolderName);
			statement.setString(2, accountType);

			int result = statement.executeUpdate();
			if (result == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}

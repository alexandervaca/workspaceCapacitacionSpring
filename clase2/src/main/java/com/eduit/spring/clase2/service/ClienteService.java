package com.eduit.spring.clase2.service;

import com.eduit.spring.clase2.dao.ClienteDAO;
import com.eduit.spring.clase2.model.Cliente;
import com.eduit.spring.clase2.model.Cuenta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("clienteService")
public class ClienteService {

	// PROPAGATION TYPE

	// MANDATORY no current transaction throw exception
	// there's a current transaction use current transaction

	// NEVER no current transaction don't create a transaction, run method
	// outside any transaction
	// there's a current transaction throw exception

	// NOT_SUPPORTED no current transaction don't create a transaction, run
	// method outside any transaction suspend current transaction,
	// there's a current transaction run method outside any transaction

	// SUPPORTS no current transaction don't create a transaction, run method
	// outside any transaction
	// there's a current transaction use current transaction

	// REQUIRED (default) no current transaction create a new transaction
	// there's a current transaction use current transaction

	// REQUIRES_NEW no current transaction create a new transaction suspend
	// current transaction,
	// there's a current transaction create a new independent transaction

	// NESTED no current transaction create a new transaction
	// there's a current transaction create a new nested transaction

	// ISOLATION

	// READ_UNCOMMITTED isolation level states that a transaction may read data
	// that is still uncommitted by other transactions. This constraint is very
	// relaxed in what matters
	// to transactional concurrency but it may lead to some issues like dirty
	// reads.

	// READ_COMMITTED isolation level states that a transaction can't read data
	// that is not yet committed
	// by other transactions. This means that the dirty read is no longer an
	// issue, but even this way
	// other issues may occur.

	// REPEATABLE_READ isolation level states that if a transaction reads one
	// record
	// from the database multiple times the result of all those reading
	// operations must always be the same.
	// This eliminates both the dirty read and the non-repeatable read issues,
	// but even this way other issues may occur.

	// SERIALIZABLE isolation level is the most restrictive of all isolation
	// levels.
	// Transactions are executed with locking at all levels (read, range and
	// write locking)
	// so they appear as if they were executed in a serialized way. This leads
	// to a scenario
	// where none of the issues mentioned above may occur, but in the other way
	// we don't allow
	// transaction concurrency and consequently introduce a performance penalty.

	@Autowired
	private ClienteDAO clienteDAO;

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public Cliente saveCliente(Cliente cliente) {
		return clienteDAO.save(cliente);
	}

	@Transactional
	public Cliente getById(Long id) {
		Cliente cliente = clienteDAO.findOne(id);
		cliente.getCuentas().size();// Con el size() se fuerza que traiga las cuentas del cliente.
		cliente.getTarjetas().size();
		return cliente;
	}

	@Transactional(readOnly = true)
	public List<Cliente> getClientesBydireccion(String direccion) {
		return clienteDAO.getClientesBydireccion(direccion);
	}

	@Transactional
	public List<Cliente> getClientesByCuentas(Cuenta cuenta) {
		return clienteDAO.getClientesByCuentas(cuenta);
	}

}

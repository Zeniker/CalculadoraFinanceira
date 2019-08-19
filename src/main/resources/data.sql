insert into conta(id, nome_pessoa) values (1, 'Guilherme');

insert into movimentacao (id, data_cobranca, data_operacao, recorrente, status, tipo_movimentacao, valor, cartao_id, conta_id, original_id)
values(1, '2019-08-13', '2019-08-13', false, 'ATIVO', 'GANHO', 10, null, 1, null);

insert into movimentacao (id, data_cobranca, data_operacao, recorrente, status, tipo_movimentacao, valor, cartao_id, conta_id, original_id)
values(2, '2019-08-13', '2019-08-13', false, 'ATIVO', 'GANHO', 100, null, 1, null);
create table Endereco(
end_id INT AUTO_INCREMENT PRIMARY KEY,
end_tipo_logradouro TEXT(50),
end_logradouro TEXT(200),
end_numero INT,
end_bairro TEXT(100),
cid_id INT,
FOREIGN KEY(cid_id) REFERENCES Cidade(cid_id)
);
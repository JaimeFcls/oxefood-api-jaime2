package br.com.ifpe.oxefoodapiJaime.modelo.cliente;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import br.com.ifpe.oxefoodapiJaime.modelo.mensagens.EmailService;



@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository repository;

    @Autowired
    private EnderecoClienteRepository enderecoClienteRepository;

    //@Autowired
    //private EmailService emailService;

    @Transactional
    public Cliente save(Cliente cliente) {

        cliente.setHabilitado(Boolean.TRUE);
        cliente.setVersao(1L);
        cliente.setDataCriacao(LocalDate.now());
        Cliente clienteSalvo = repository.save(cliente);

       //emailService.enviarEmailConfirmacaoCadastroCliente(clienteSalvo);

       return clienteSalvo;

    }

    public List<Cliente> findAll() {
  
        return repository.findAll();
    }

    public Cliente findById(Long id) {

        return repository.findById(id).get();
    }

    public List<Cliente> filtrar(String cpf, String nome){
        List<Cliente> listaClientes = repository.findAll();
        if ((cpf != null && !"".equals(cpf)) &&
            (nome == null || "".equals(nome)))
             {
                listaClientes = repository.findByCpf(cpf);
        
        } 
        else if(
            (nome != null && !"".equals(nome)) &&
            (cpf == null || "".equals(cpf)))
             {
                listaClientes = repository.findByNome(nome);
             }
        else if(
            (nome == null && !"".equals(nome)) &&
            (cpf == null || "".equals(cpf)))
             {
                listaClientes = repository.findByCpfAndNome(cpf, nome);
             }
        return listaClientes;
    }
    @Transactional
    public void update(Long id, Cliente clienteAlterado) {

        Cliente cliente = repository.findById(id).get();
        cliente.setNome(clienteAlterado.getNome());
        cliente.setDataNascimento(clienteAlterado.getDataNascimento());
        cliente.setCpf(clienteAlterado.getCpf());
        cliente.setFoneCelular(clienteAlterado.getFoneCelular());
        cliente.setFoneFixo(clienteAlterado.getFoneFixo());
            
        cliente.setVersao(cliente.getVersao() + 1);
        repository.save(cliente);
    }

    @Transactional
    public void delete(Long id) {

        Cliente cliente = repository.findById(id).get();
        cliente.setHabilitado(Boolean.FALSE);
        cliente.setVersao(cliente.getVersao() + 1);

        repository.save(cliente);
    }

    @Transactional
    public EnderecoCliente adicionarEnderecoCliente(Long clienteId, EnderecoCliente endereco) {

        Cliente cliente = this.findById(clienteId);
        
        //Primeiro salva o EnderecoCliente:

        endereco.setCliente(cliente);
        endereco.setHabilitado(Boolean.TRUE);
        enderecoClienteRepository.save(endereco);
        
        //Depois acrescenta o endereço criado ao cliente e atualiza o cliente:

        List<EnderecoCliente> listaEnderecoCliente = cliente.getEnderecos();
        
        if (listaEnderecoCliente == null) {
            listaEnderecoCliente = new ArrayList<EnderecoCliente>();
        }
        
        listaEnderecoCliente.add(endereco);
        cliente.setEnderecos(listaEnderecoCliente);
        this.save(cliente);
        
        return endereco;
    }

    @Transactional
   public EnderecoCliente atualizarEnderecoCliente(Long id, EnderecoCliente enderecoAlterado) {

       EnderecoCliente endereco = enderecoClienteRepository.findById(id).get();
       endereco.setRua(enderecoAlterado.getRua());
       endereco.setNumero(enderecoAlterado.getNumero());
       endereco.setBairro(enderecoAlterado.getBairro());
       endereco.setCep(enderecoAlterado.getCep());
       endereco.setCidade(enderecoAlterado.getCidade());
       endereco.setEstado(enderecoAlterado.getEstado());
       endereco.setComplemento(enderecoAlterado.getComplemento());

       return enderecoClienteRepository.save(endereco);
   }

   @Transactional
   public void removerEnderecoCliente(Long id) {

       EnderecoCliente endereco = enderecoClienteRepository.findById(id).get();
       endereco.setHabilitado(Boolean.FALSE);
       enderecoClienteRepository.save(endereco);

       Cliente cliente = this.findById(endereco.getCliente().getId());
       cliente.getEnderecos().remove(endereco);
       this.save(cliente);
   }


}
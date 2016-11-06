/**
 * @author Fernando Moraes Oliveira
 * Matéria Engenharia de Software 2
 * FATEC ZL 5º ADS - Tarde
 * 19/10/2016
 */

package edu.pousada.boundary;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.ParseException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

import edu.pousada.controller.PrincipalCtrl;

public class PrincipalFrm extends JFrame {

	private static final long serialVersionUID = -7459629918660280765L;
	private String versao;
	private JPanel painel;
	private JLabel lblLogin;
	private JLabel lblPwd;
	private JLabel lblMsg;
	private JLabel lblRelogio;
	private JLabel lblReservaMsg;
	private JLabel lblContatoMsg;
	private JLabel lblVersao;
	private JLabel lblPrincipalImg;
	private JLabel lblChaleImg;
	private JLabel lblLazerImg;
	private JLabel lblServicoImg;
	private JLabel lblReservaImg;
	private JTextField txtLogin;
	private JTextField txtPesquisa;
	private JTextField txtReservaQtdAdulto;
	private JTextField txtReservaQtdCrianca;
	private JTextField txtReservaNome;
	private JTextField txtReservaDocNum;
	private JTextField txtReservaEmail;
	private JTextField txtReservaTelefone;
	private JTextField txtReservaCelular;
	private JTextField txtReservaCidade;
	private JTextField txtReservaEstado;
	private JTextField txtReservaPais;
	private JTextField txtContatoNome;
	private JTextField txtContatoEmail;
	private JTextField txtContatoTelefone;
	private JTextField txtContatoCidade;
	private JTextField txtContatoEstado;
	private JTextField txtContatoPais;
	private JPasswordField pwdSenha;
	private JFormattedTextField ftxtReservaDtInicio;
	private JFormattedTextField ftxtReservaDtFim;
	private JFormattedTextField ftxtQtdReservaServico;
	private JFormattedTextField ftxtVlrReservaServico;
	private JFormattedTextField ftxtQtdReservaChale;
	private JFormattedTextField ftxtVlrChale;
	private JTextArea txtaPrincipalInfo;
	private JTextArea txtaPrincipalDetalhe;
	private JTextArea txtaChaleInfo;
	private JTextArea txtaChaleDetalhe;
	private JTextArea txtaLazerInfo;
	private JTextArea txtaLazerDetalhe;
	private JTextArea txtaServicoInfo;
	private JTextArea txtaServicoDetalhe;
	private JTextArea txtaReservaInfo;
	private JTextArea txtaReservaMsg;
	private JTextArea txtaContatoInfo;
	private JTextArea txtaContatoMsg;
	private JComboBox<String> cboReservaCategoria;
	private JComboBox<String> cboReservaDocTipo;
	private JComboBox<String> cboContatoAssunto;
	private JButton btnLogin;
	private JButton btnReservas;
	private JButton btnPesquisar;
	private JButton btnReservaEnviar;
	private JButton btnContatoEnviar;
	private JButton btnReservaLimpar;
	private JButton btnContatoLimpar;
	private JTable tabReserva;
	private JTable tabServico;
	private JTabbedPane tabContainer;
	private JScrollPane spChale;
	private JScrollPane spTabReservaServico;
	private JPanel painelPrincipal;
	private JPanel painelChale;
	private JPanel painelLazer;
	private JPanel painelServico;
	private JPanel painelReserva;
	private JPanel painelContato;
	private JPanel painelPrincipalAdm;
	private JPanel painelReservaAdm;
	private JPanel painelChaleAdm;
	private JPanel painelServicoAdm;
	private DecimalFormat maskValor;
	private ImageIcon fundo = new ImageIcon( "../Pousada/resources/backstage/img4.jpg" );
	private ImageIcon principal = new ImageIcon( "../Pousada/resources/imagens/externa0.jpg" );
	private ImageIcon chale = new ImageIcon( "../Pousada/resources/imagens/chale0.jpg" );
	private ImageIcon lazer = new ImageIcon( "../Pousada/resources/imagens/lazer0.jpg" );
	private ImageIcon servico = new ImageIcon( "../Pousada/resources/imagens/servico0.jpg" );
	private ImageIcon contato = new ImageIcon( "../Pousada/resources/imagens/local0.png" );
	private Border borderClean = BorderFactory.createLineBorder(Color.LIGHT_GRAY);

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalFrm frame = new PrincipalFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PrincipalFrm() throws ParseException {

		setTitle("Pousada Inn Von Dix");
		setName("Principal");
		setBounds(100, 100, 1024, 730);
		setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
		setLocationRelativeTo(null);
		setResizable(false);

		painel = new JPanel();
		setContentPane( painel );
		painel.setName("Principal");
		painel.setLayout(null);

		JLabel lblLogo = new JLabel("POUSADA INN VON DIX");
		lblLogo.setEnabled(false);
		lblLogo.setForeground(Color.DARK_GRAY);
		lblLogo.setFont(new Font("Bauhaus 93", Font.PLAIN, 40));
		lblLogo.setBounds(31, 16, 407, 45);
		painel.add(lblLogo);

		lblLogin = new JLabel("Usuário:");
		lblLogin.setBounds(696, 22, 62, 16);
		lblLogin.setVisible(true);
		painel.add(lblLogin);

		txtLogin = new JTextField(20);
		txtLogin.setToolTipText("Digite seu usuário");
		txtLogin.setBounds(756, 16, 105, 28);
		txtLogin.setVisible(true);
		painel.add(txtLogin);

		lblPwd = new JLabel("Senha:");
		lblPwd.setBounds(696, 57, 62, 16);
		lblPwd.setVisible(true);
		painel.add(lblPwd);

		pwdSenha = new JPasswordField(20);
		pwdSenha.setToolTipText("Digite sua senha");
		pwdSenha.setBounds(756, 51, 105, 28);
		pwdSenha.setVisible(true);
		painel.add(pwdSenha);

		btnLogin = new JButton("Login");
		btnLogin.setBounds(872, 51, 116, 29);
		//		btnLogin.setToolTipText("Clique aqui para se logar ou registrar");
		btnLogin.setVisible(true);
		painel.add(btnLogin);

		btnReservas = new JButton("Reservas");
		btnReservas.setBounds(872, 16, 116, 29);
		//		btnReservas.setToolTipText("Clique aqui para se acessar a tela de Reservas");
		btnReservas.setVisible(false);
		btnReservas.setFocusable(false);
		painel.add(btnReservas);

		lblMsg = new JLabel("");
		lblMsg.setEnabled(false);
		lblMsg.setBounds(115, 57, 407, 16);
		painel.add(lblMsg);

		lblRelogio = new JLabel("");
		lblRelogio.setEnabled(false);
		lblRelogio.setBounds(35, 57, 100, 16);
		painel.add(lblRelogio);

		tabContainer = new JTabbedPane(JTabbedPane.TOP);
		tabContainer.setBounds(23, 92, 976, 580);
		painel.add(tabContainer);

		painelPrincipal = new JPanel();
		painelChale = new JPanel();
		painelLazer = new JPanel();
		painelServico = new JPanel();
		painelReserva = new JPanel();
		painelContato = new JPanel();

		painelPrincipal.setLayout(null);
		painelChale.setLayout(null);
		painelLazer.setLayout(null);
		painelServico.setLayout(null);
		painelReserva.setLayout(null);
		painelContato.setLayout(null);

		painelPrincipalAdm = new JPanel();
		painelReservaAdm = new JPanel();
		painelChaleAdm = new JPanel();
		painelServicoAdm = new JPanel();

		painelPrincipalAdm.setLayout(null);
		painelReservaAdm.setLayout(null);
		painelChaleAdm.setLayout(null);
		painelServicoAdm.setLayout(null);


		// PRINCIPAL //////////////////////////

		JLabel lblPrincipalInfo = new JLabel("SEJA BEM VINDO, visitante!");
		lblPrincipalInfo.setBounds(20, 22, 500, 16);		
		painelPrincipal.add(lblPrincipalInfo);

		txtaPrincipalInfo = new JTextArea();
		txtaPrincipalInfo.setBounds(20, 46, 914, 90);
		txtaPrincipalInfo.setBorder(BorderFactory.createCompoundBorder(borderClean, 
				BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		txtaPrincipalInfo.setFocusable(false);
		txtaPrincipalInfo.setEditable(false);
		txtaPrincipalInfo .setLineWrap(true);
		txtaPrincipalInfo .setWrapStyleWord(true);
		painelPrincipal.add(txtaPrincipalInfo);

		JLabel lblPrincipal = new JLabel("O que oferecemos:");
		lblPrincipal.setBounds(600, 175, 300, 16);
		painelPrincipal.add(lblPrincipal);

		txtaPrincipalDetalhe = new JTextArea(10, 20);
		txtaPrincipalDetalhe.setBounds(600, 203, 334, 312);
		txtaPrincipalDetalhe.setBorder(BorderFactory.createCompoundBorder(borderClean, 
				BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		txtaPrincipalDetalhe.setFocusable(false);
		txtaPrincipalDetalhe.setEditable(false);
		txtaPrincipalDetalhe.setLineWrap(true);
		txtaPrincipalDetalhe.setWrapStyleWord(true);
		painelPrincipal.add(txtaPrincipalDetalhe);

		lblPrincipalImg = new JLabel();
		lblPrincipalImg.setBounds(20, 178, 555, 337);
		lblPrincipalImg.setName( "lblPrincipalImg");
		lblPrincipalImg.setFocusable(false);
		lblPrincipalImg.setToolTipText("Vista da pousada");
		lblPrincipalImg.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrincipalImg.setBorder(new LineBorder(Color.LIGHT_GRAY));
		lblPrincipalImg.setVisible(true);
		lblPrincipalImg.setIcon(new ImageIcon(
				principal.getImage().getScaledInstance(
						lblPrincipalImg.getWidth(), 
						lblPrincipalImg.getHeight(), 
						Image.SCALE_DEFAULT)));
		painelPrincipal.add(lblPrincipalImg);

		// CHALE //////////////////////////

		JLabel lblChaleInfo = new JLabel("Conheça nossas acomodações!");
		lblChaleInfo.setBounds(20, 22, 500, 16);		
		painelChale.add(lblChaleInfo);

		txtaChaleInfo = new JTextArea();
		txtaChaleInfo.setBounds(20, 46, 914, 90);
		txtaChaleInfo.setBorder(BorderFactory.createCompoundBorder(borderClean, 
				BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		txtaChaleInfo.setFocusable(false);
		txtaChaleInfo.setEditable(false);
		txtaChaleInfo .setLineWrap(true);
		txtaChaleInfo .setWrapStyleWord(true);
		painelChale.add(txtaChaleInfo);

		JLabel lblChale = new JLabel("Nossos Chalés:");
		lblChale.setBounds(600, 175, 300, 16);
		painelChale.add(lblChale);

		txtaChaleDetalhe = new JTextArea(10, 20);
		txtaChaleDetalhe.setBounds(600, 203, 334, 312);
		txtaChaleDetalhe.setBorder(BorderFactory.createCompoundBorder(borderClean, 
				BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		txtaChaleDetalhe.setFocusable(false);
		txtaChaleDetalhe.setFocusable(false);
		txtaChaleDetalhe.setEditable(false);
		txtaChaleDetalhe.setLineWrap(true);
		txtaChaleDetalhe.setWrapStyleWord(true);
		painelChale.add(txtaChaleDetalhe);

		lblChaleImg = new JLabel();
		lblChaleImg.setBounds(20, 178, 555, 337);
		lblChaleImg.setName( "lblChaleImg");
		lblChaleImg.setToolTipText("Vista de nossas acomodações");
		lblChaleImg.setHorizontalAlignment(SwingConstants.CENTER);
		lblChaleImg.setBorder(new LineBorder(Color.LIGHT_GRAY));
		lblChaleImg.setVisible(true);
		lblChaleImg.setIcon(new ImageIcon(
				chale.getImage().getScaledInstance(
						lblChaleImg.getWidth(), 
						lblChaleImg.getHeight(), 
						Image.SCALE_DEFAULT)));
		painelChale.add(lblChaleImg);

		// LAZER //////////////////////////

		JLabel lblLazerInfo = new JLabel("Nossa programação de lazer!");
		lblLazerInfo.setBounds(20, 22, 500, 16);		
		painelLazer.add(lblLazerInfo);

		txtaLazerInfo = new JTextArea();
		txtaLazerInfo.setBounds(20, 46, 914, 90);
		txtaLazerInfo.setBorder(BorderFactory.createCompoundBorder(borderClean, 
				BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		txtaLazerInfo.setFocusable(true);
		txtaLazerInfo.setEditable(false);
		txtaLazerInfo .setLineWrap(true);
		txtaLazerInfo .setWrapStyleWord(true);
		painelLazer.add(txtaLazerInfo);

		JLabel lblLazer = new JLabel("Seu lazer garantido:");
		lblLazer.setBounds(600, 175, 300, 16);
		painelLazer.add(lblLazer);

		txtaLazerDetalhe = new JTextArea(10, 20);
		txtaLazerDetalhe.setBounds(600, 203, 334, 312);
		txtaLazerDetalhe.setBorder(BorderFactory.createCompoundBorder(borderClean, 
				BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		txtaLazerDetalhe.setFocusable(false);
		txtaLazerDetalhe.setEditable(false);
		txtaLazerDetalhe.setLineWrap(true);
		txtaLazerDetalhe.setWrapStyleWord(true);
		painelLazer.add(txtaLazerDetalhe);

		lblLazerImg = new JLabel();
		lblLazerImg.setBounds(20, 178, 555, 337);
		lblLazerImg.setName( "lblLazerImg" );
		lblLazerImg.setToolTipText("Atividades de Lazer.");
		lblLazerImg.setFocusable(false);
		lblLazerImg.setHorizontalAlignment(SwingConstants.CENTER);
		lblLazerImg.setBorder(new LineBorder(Color.LIGHT_GRAY));
		lblLazerImg.setVisible(true);
		lblLazerImg.setIcon(new ImageIcon(lazer.getImage().getScaledInstance(
				lblLazerImg.getWidth(), 
				lblLazerImg.getHeight(), 
				Image.SCALE_DEFAULT)));
		painelLazer.add(lblLazerImg);

		// SERVICO //////////////////////////

		JLabel lblServicoInfo = new JLabel("Serviços que oferecemos.");
		lblServicoInfo.setBounds(20, 22, 500, 16);		
		painelServico.add(lblServicoInfo);

		txtaServicoInfo = new JTextArea();
		txtaServicoInfo.setBounds(20, 46, 914, 90);
		txtaServicoInfo.setBorder(BorderFactory.createCompoundBorder(borderClean, 
				BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		txtaServicoInfo.setFocusable(false);
		txtaServicoInfo.setEditable(false);
		txtaServicoInfo .setLineWrap(true);
		txtaServicoInfo .setWrapStyleWord(true);
		painelServico.add(txtaServicoInfo);

		JLabel lblServico = new JLabel("Nossos serviços para o seu conforto:");
		lblServico.setBounds(600, 175, 300, 16);
		painelServico.add(lblServico);

		txtaServicoDetalhe = new JTextArea(10, 20);
		txtaServicoDetalhe.setBounds(600, 203, 334, 312);
		txtaServicoDetalhe.setBorder(BorderFactory.createCompoundBorder(borderClean, 
				BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		txtaServicoDetalhe.setFocusable(false);
		txtaServicoDetalhe.setEditable(false);
		txtaServicoDetalhe.setLineWrap(true);
		txtaServicoDetalhe.setWrapStyleWord(true);
		painelServico.add(txtaServicoDetalhe);

		lblServicoImg = new JLabel();
		lblServicoImg.setBounds(20, 178, 555, 337);
		lblServicoImg.setName( "lblServicoImg" );
		lblServicoImg.setToolTipText("Serviços oferecidos");
		lblServicoImg.setFocusable(false);
		lblServicoImg.setHorizontalAlignment(SwingConstants.CENTER);
		lblServicoImg.setBorder(new LineBorder(Color.LIGHT_GRAY));
		lblServicoImg.setVisible(true);
		lblServicoImg.setIcon(new ImageIcon(servico.getImage().getScaledInstance(
				lblServicoImg.getWidth(), 
				lblServicoImg.getHeight(), 
				Image.SCALE_DEFAULT)));
		painelServico.add(lblServicoImg);

		// RESERVA //////////////////////////

		JLabel lblReservaInfo = new JLabel("Como realizar a sua reserva?");
		lblReservaInfo.setBounds(20, 22, 500, 16);		
		painelReserva.add(lblReservaInfo);

		txtaReservaInfo = new JTextArea();
		txtaReservaInfo.setBounds(20, 46, 914, 90);
		txtaReservaInfo.setName("reservaInfo");
		txtaReservaInfo.setBorder(BorderFactory.createCompoundBorder(borderClean, 
				BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		txtaReservaInfo.setFocusable(false);
		txtaReservaInfo.setEditable(false);
		txtaReservaInfo .setLineWrap(true);
		txtaReservaInfo .setWrapStyleWord(true);
		painelReserva.add(txtaReservaInfo);

		JLabel lblReservaNome = new JLabel("Nome:");
		lblReservaNome.setBounds(20, 157, 150, 16);
		painelReserva.add(lblReservaNome);

		txtReservaNome = new JTextField(20);
		txtReservaNome.setBounds(105, 151, 400, 28);
		txtReservaNome.setName("Nome");
		txtReservaNome.setToolTipText("Digite seu nome completo");
		painelReserva.add(txtReservaNome);

		JLabel lblReservaEmail = new JLabel("Email:");
		lblReservaEmail.setBounds(20, 197, 150, 16);
		painelReserva.add(lblReservaEmail);

		txtReservaEmail = new JTextField(20);
		txtReservaEmail.setBounds(105, 191, 400, 28);
		txtReservaEmail.setName("Email");
		txtReservaEmail.setToolTipText("Digite seu Email");
		painelReserva.add(txtReservaEmail);

		JLabel lblReservaDocNum = new JLabel("Documento:");
		lblReservaDocNum.setBounds(20, 237, 150, 16);
		painelReserva.add(lblReservaDocNum);

		txtReservaDocNum = new JTextField(20);
		txtReservaDocNum.setBounds(105, 231, 150, 28);
		txtReservaDocNum.setName("Número de Documento");
		txtReservaDocNum.setToolTipText("Digite seu Documento");
		painelReserva.add(txtReservaDocNum);

		JLabel lblReservaDocTipo = new JLabel("Tipo:");
		lblReservaDocTipo.setBounds(290, 237, 100, 16);
		lblReservaDocTipo.setToolTipText("Selecione o tipo de documento");
		painelReserva.add(lblReservaDocTipo);

		cboReservaDocTipo = new JComboBox<String>();
		cboReservaDocTipo.setBounds(355, 231, 150, 27);
		cboReservaDocTipo.setName("Tipo de Documento");
		painelReserva.add(cboReservaDocTipo);

		JLabel lblReservaTelefone = new JLabel("Telefone:");
		lblReservaTelefone.setBounds(20, 277, 150, 16);
		painelReserva.add(lblReservaTelefone);

		txtReservaTelefone = new JTextField(20);
		txtReservaTelefone.setBounds(105, 271, 150, 28);
		txtReservaTelefone.setName("Telefone");
		txtReservaTelefone.setToolTipText("Digite seu Telefone");
		painelReserva.add(txtReservaTelefone);

		JLabel lblReservaCelular = new JLabel("Celular:");
		lblReservaCelular.setBounds(290, 277, 150, 16);
		painelReserva.add(lblReservaCelular);

		txtReservaCelular = new JTextField(20);
		txtReservaCelular.setBounds(355, 271, 150, 28);
		txtReservaCelular.setName("Celular");
		txtReservaCelular.setToolTipText("Digite seu Celular");
		painelReserva.add(txtReservaCelular);

		JLabel lblReservaCidade = new JLabel("Cidade:");
		lblReservaCidade.setBounds(20, 317, 150, 16);
		painelReserva.add(lblReservaCidade);

		txtReservaCidade = new JTextField(20);
		txtReservaCidade.setBounds(105, 311, 150, 28);
		txtReservaCidade.setName("Cidade");
		txtReservaCidade.setToolTipText("Digite sua Cidade");
		painelReserva.add(txtReservaCidade);

		JLabel lblReservaEstado = new JLabel("Estado:");
		lblReservaEstado.setBounds(290, 317, 150, 16);
		painelReserva.add(lblReservaEstado);

		txtReservaEstado = new JTextField(20);
		txtReservaEstado.setBounds(355, 311, 150, 28);
		txtReservaEstado.setName("Estado");
		txtReservaEstado.setToolTipText("Digite seu Estado");
		painelReserva.add(txtReservaEstado);

		JLabel lblReservaPais = new JLabel("País:");
		lblReservaPais.setBounds(290, 357, 150, 16);
		painelReserva.add(lblReservaPais);

		txtReservaPais = new JTextField(20);
		txtReservaPais.setBounds(355, 351, 150, 28);
		txtReservaPais.setName("País");
		txtReservaPais.setToolTipText("Digite seu País");
		painelReserva.add(txtReservaPais);

		lblReservaMsg = new JLabel("Observações (0 de 300):");
		lblReservaMsg.setBounds(20, 377, 484, 16);		
		painelReserva.add(lblReservaMsg);

		txtaReservaMsg = new JTextArea();
		txtaReservaMsg.setBounds(20, 401, 484, 114);
		txtaReservaMsg.setName("Observações");
		txtaReservaMsg.setBorder(BorderFactory.createCompoundBorder(borderClean, 
				BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		txtaReservaMsg.setBorder(new LineBorder(Color.LIGHT_GRAY));
		txtaReservaMsg.setLineWrap(true);
		txtaReservaMsg.setWrapStyleWord(true);
		painelReserva.add(txtaReservaMsg);

		JLabel lblReservaCategoria = new JLabel("Categoria do Chalé:");
		lblReservaCategoria.setBounds(610, 157, 125, 16);
		painelReserva.add(lblReservaCategoria);

		cboReservaCategoria = new JComboBox<String>();
		cboReservaCategoria.setBounds(755, 152, 185, 27);
		cboReservaCategoria.setName("Categoria do Chalé");
		cboReservaCategoria.setToolTipText("Selecione a categoria do Chalé");
		cboReservaCategoria.setFocusable( false );
		painelReserva.add(cboReservaCategoria);

		lblReservaImg = new JLabel();
		lblReservaImg.setBounds(610, 193, 324, 197);
		lblReservaImg.setName( "lblReservaImg" );
		lblReservaImg.setToolTipText("Acomodações do Chalé");
		lblReservaImg.setFocusable(false);
		lblReservaImg.setHorizontalAlignment(SwingConstants.CENTER);
		lblReservaImg.setBorder(new LineBorder(Color.LIGHT_GRAY));
		lblReservaImg.setVisible(true);
		lblReservaImg.setIcon(new ImageIcon(chale.getImage().getScaledInstance(
				lblReservaImg.getWidth(), 
				lblReservaImg.getHeight(), 
				Image.SCALE_DEFAULT)));
		painelReserva.add(lblReservaImg);

		JLabel lblReservaDtInicio = new JLabel("Chegada:");
		lblReservaDtInicio.setBounds(610, 413, 100, 16);
		painelReserva.add(lblReservaDtInicio);

		MaskFormatter mskData = new MaskFormatter("##/##/####");
		ftxtReservaDtInicio = new JFormattedTextField(mskData);
		ftxtReservaDtInicio.setBounds(670, 406, 100, 28);
		ftxtReservaDtInicio.setName("Data Inícial");
		ftxtReservaDtInicio.setToolTipText("Digite a data inicial de sua estadia");
		ftxtReservaDtInicio.setHorizontalAlignment(SwingConstants.CENTER);
		painelReserva.add(ftxtReservaDtInicio);

		JLabel lblReservaDtFim = new JLabel("Partida:");
		lblReservaDtFim.setBounds(775, 413, 100, 16);
		painelReserva.add(lblReservaDtFim);

		mskData = new MaskFormatter("##/##/####");
		ftxtReservaDtFim = new JFormattedTextField(mskData);
		ftxtReservaDtFim.setBounds(835, 406, 100, 28);
		ftxtReservaDtFim.setName("Data Final");
		ftxtReservaDtFim.setToolTipText("Digite a data final de sua estadia");
		ftxtReservaDtFim.setHorizontalAlignment(SwingConstants.CENTER);
		painelReserva.add(ftxtReservaDtFim);

		JLabel lblReservaQtdAdulto = new JLabel("Adultos:");
		lblReservaQtdAdulto.setBounds(610, 453, 100, 16);
		painelReserva.add(lblReservaQtdAdulto);

		txtReservaQtdAdulto = new JTextField(20);
		txtReservaQtdAdulto.setBounds(670, 447, 100, 28);
		txtReservaQtdAdulto.setName("Adultos");
		txtReservaQtdAdulto.setToolTipText("Digite a quantidade de Adultos");
		txtReservaQtdAdulto.setHorizontalAlignment(SwingConstants.CENTER);
		painelReserva.add(txtReservaQtdAdulto);

		JLabel lblReservaQtdCrianca = new JLabel("Crianças:");
		lblReservaQtdCrianca.setBounds(775, 453, 100, 16);
		painelReserva.add(lblReservaQtdCrianca);

		txtReservaQtdCrianca = new JTextField(20);
		txtReservaQtdCrianca.setBounds(835, 447, 100, 28);
		txtReservaQtdCrianca.setName("Crianças");
		txtReservaQtdCrianca.setToolTipText("Digite a quantidade de Crianças");
		txtReservaQtdCrianca.setHorizontalAlignment(SwingConstants.CENTER);
		painelReserva.add(txtReservaQtdCrianca);

		btnReservaLimpar = new JButton("Limpar");
		btnReservaLimpar.setBounds(715, 485, 110, 29);
		btnReservaLimpar.setToolTipText("Clique aqui para limpar os campos preenchidos");
		btnReservaLimpar.setVisible(true);
		painelReserva.add(btnReservaLimpar);

		btnReservaEnviar = new JButton("Reservar");
		btnReservaEnviar.setBounds(830, 485, 110, 29);
		painelReserva.add(btnReservaEnviar);


		// CONTATO //////////////////////////

		JLabel lblContatoInfo = new JLabel("Fale conosco");
		lblContatoInfo.setBounds(20, 22, 500, 16);		
		painelContato.add(lblContatoInfo);

		txtaContatoInfo = new JTextArea();
		txtaContatoInfo.setBounds(20, 46, 914, 90);
		txtaContatoInfo.setName("contatoInfo");
		txtaContatoInfo.setBorder(BorderFactory.createCompoundBorder(borderClean, 
				BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		txtaContatoInfo.setFocusable(false);
		txtaContatoInfo.setEditable(false);
		txtaContatoInfo .setLineWrap(true);
		txtaContatoInfo .setWrapStyleWord(true);
		painelContato.add(txtaContatoInfo);

		JLabel lblContatoLocal= new JLabel("Nossa localização:");
		lblContatoLocal.setBounds(505, 217, 150, 16);
		painelContato.add(lblContatoLocal);

		JLabel lblContatoImg = new JLabel();
		lblContatoImg.setBounds(505, 245, 428, 269);
		lblContatoImg.setName( "lblContatoImg" );
		lblContatoImg.setToolTipText("Localização da pousada");
		lblContatoImg.setHorizontalAlignment(SwingConstants.CENTER);
		lblContatoImg.setBorder(new LineBorder(Color.GRAY));
		lblContatoImg.setFocusable(false);
		lblContatoImg.setVisible(true);
		lblContatoImg.setIcon(new ImageIcon(contato.getImage().getScaledInstance(
				lblContatoImg.getWidth(), 
				lblContatoImg.getHeight(), 
				Image.SCALE_DEFAULT)));
		painelContato.add(lblContatoImg);

		JLabel lblContatoNome = new JLabel("Nome:");
		lblContatoNome.setBounds(20, 157, 150, 16);
		painelContato.add(lblContatoNome);

		txtContatoNome = new JTextField(20);
		txtContatoNome.setBounds(85, 151, 400, 28);
		txtContatoNome.setName("Nome");
		txtContatoNome.setToolTipText("Digite seu nome completo");
		painelContato.add(txtContatoNome);

		JLabel lblContatoEmail = new JLabel("Email:");
		lblContatoEmail.setBounds(20, 197, 150, 16);
		painelContato.add(lblContatoEmail);

		txtContatoEmail = new JTextField(20);
		txtContatoEmail.setBounds(85, 191, 400, 28);
		txtContatoEmail.setName("Email");
		txtContatoEmail.setToolTipText("Digite seu Email");
		painelContato.add(txtContatoEmail);

		JLabel lblContatoTelefone = new JLabel("Telefone:");
		lblContatoTelefone.setBounds(20, 237, 150, 16);
		painelContato.add(lblContatoTelefone);

		txtContatoTelefone = new JTextField(20);
		txtContatoTelefone.setBounds(85, 231, 150, 28);
		txtContatoTelefone.setName("Telefone");
		txtContatoTelefone.setToolTipText("Digite seu Telefone");
		painelContato.add(txtContatoTelefone);

		JLabel lblContatoCidade = new JLabel("Cidade:");
		lblContatoCidade.setBounds(285, 237, 150, 16);
		painelContato.add(lblContatoCidade);

		txtContatoCidade = new JTextField(20);
		txtContatoCidade.setBounds(335, 231, 150, 28);
		txtContatoCidade.setName("Cidade");
		txtContatoCidade.setToolTipText("Digite sua Cidade");
		painelContato.add(txtContatoCidade);

		JLabel lblContatoEstado = new JLabel("Estado:");
		lblContatoEstado.setBounds(20, 277, 150, 16);
		painelContato.add(lblContatoEstado);

		txtContatoEstado = new JTextField(20);
		txtContatoEstado.setBounds(85, 271, 150, 28);
		txtContatoEstado.setName("Estado");
		txtContatoEstado.setToolTipText("Digite seu Estado");
		painelContato.add(txtContatoEstado);

		JLabel lblContatoPais = new JLabel("País:");
		lblContatoPais.setBounds(285, 277, 150, 16);
		painelContato.add(lblContatoPais);

		txtContatoPais = new JTextField(20);
		txtContatoPais.setBounds(335, 271, 150, 28);
		txtContatoPais.setName("País");
		txtContatoPais.setToolTipText("Digite seu País");
		painelContato.add(txtContatoPais);

		JLabel lblContatoAssunto = new JLabel("Assunto:");
		lblContatoAssunto.setBounds(20, 337, 100, 16);
		lblContatoAssunto.setToolTipText("Selecione um asssunto para a sua mensagem");
		painelContato.add(lblContatoAssunto);

		cboContatoAssunto = new JComboBox<String>();
		cboContatoAssunto.setBounds(85, 331, 285, 27);
		cboContatoAssunto.setName("Assunto");
		painelContato.add(cboContatoAssunto);

		lblContatoMsg = new JLabel("Sua mensagem (0 de 300):");
		lblContatoMsg.setBounds(20, 377, 460, 16);	
		painelContato.add(lblContatoMsg);

		txtaContatoMsg = new JTextArea();
		txtaContatoMsg.setBounds(20, 401, 460, 114);
		txtaContatoMsg.setName("Mensagem");
		txtaContatoMsg.setBorder(BorderFactory.createCompoundBorder(borderClean, 
				BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		txtaContatoMsg.setBorder(new LineBorder(Color.LIGHT_GRAY));
		txtaContatoMsg.setLineWrap(true);
		txtaContatoMsg.setWrapStyleWord(true);
		painelContato.add(txtaContatoMsg);

		btnContatoLimpar = new JButton("Limpar");
		btnContatoLimpar.setBounds(390, 331, 100, 29);
		btnContatoLimpar.setToolTipText("Clique aqui para limpar os campos preenchidos");
		btnContatoLimpar.setFocusable(false);
		btnContatoLimpar.setVisible(true);
		painelContato.add(btnContatoLimpar);

		btnContatoEnviar = new JButton("Enviar");
		btnContatoEnviar.setBounds(390, 365, 100, 29);
		btnContatoEnviar.setFocusable(false);
		painelContato.add(btnContatoEnviar);


		// PRINCIPAL ADM //////////////////////////

		JLabel lblPesquisa = new JLabel("Pesquisar cliente:");
		lblPesquisa.setBounds(37, 17, 117, 16);
		painelPrincipalAdm.add(lblPesquisa);

		txtPesquisa = new JTextField(20);
		txtPesquisa.setBounds(161, 11, 239, 28);
		txtPesquisa.setToolTipText("Digite o nome ou código como critério");
		painelPrincipalAdm.add(txtPesquisa);

		btnPesquisar = new JButton("");
		btnPesquisar.setBounds(410, 11, 28, 28);
		btnPesquisar.setIcon(new ImageIcon("../Pousada/resources/icons/btn_search.png"));
		btnPesquisar.setVisible(true);
		painelPrincipalAdm.add(btnPesquisar);

		JLabel lblTabChale = new JLabel("Reservas de Chalés");
		lblTabChale.setBounds(800, 30, 130, 16);
		painelPrincipalAdm.add(lblTabChale);

		spChale = new JScrollPane();
		spChale.setBounds(30, 50, 895, 180);
		spChale.setToolTipText("clique 2 vezes para cancelar");
		painelPrincipalAdm.add(spChale);

		tabReserva = new JTable();
		tabReserva.setName("reserva");
		tabReserva.setBorder(null);
		tabReserva.setAutoCreateRowSorter(true);
		spChale.setViewportView(tabReserva);

		JLabel lblQtdReservaChale = new JLabel("Quantidade");
		lblQtdReservaChale.setBounds(30, 240, 73, 16);
		painelPrincipalAdm.add(lblQtdReservaChale);

		ftxtQtdReservaChale = new JFormattedTextField((Format) null);
		ftxtQtdReservaChale.setBackground(SystemColor.window);
		ftxtQtdReservaChale.setHorizontalAlignment(SwingConstants.CENTER);
		ftxtQtdReservaChale.setEditable(false);
		ftxtQtdReservaChale.setColumns(10);
		ftxtQtdReservaChale.setBounds(111, 235, 58, 28);
		painelPrincipalAdm.add(ftxtQtdReservaChale);

		JLabel lblVlrReservaChale = new JLabel("Total Geral");
		lblVlrReservaChale.setBounds(192, 240, 73, 16);
		painelPrincipalAdm.add(lblVlrReservaChale);

		maskValor = new DecimalFormat("R$ #,###,##0.00");
		NumberFormatter totalChale = new NumberFormatter(maskValor);
		totalChale.setFormat(maskValor);
		totalChale.setAllowsInvalid(false);
		ftxtVlrChale = new JFormattedTextField(maskValor);
		ftxtVlrChale.setBackground(SystemColor.window);
		ftxtVlrChale.setHorizontalAlignment(SwingConstants.RIGHT);
		ftxtVlrChale.setEditable(false);
		ftxtVlrChale.setBounds(264, 235, 98, 28);
		ftxtVlrChale.setColumns(10);
		painelPrincipalAdm.add(ftxtVlrChale);

		JLabel lblTabReservaServico = new JLabel("Reservas de Serviços");
		lblTabReservaServico.setBounds(790, 280, 130, 16);
		painelPrincipalAdm.add(lblTabReservaServico);

		spTabReservaServico = new JScrollPane();
		spTabReservaServico.setBounds(30, 300, 895, 180);
		spTabReservaServico.setToolTipText("clique 2 vezes para cancelar");
		painelPrincipalAdm.add(spTabReservaServico);

		tabServico = new JTable();
		tabServico.setName("servico");
		tabServico.setBorder(null);
		tabServico.setAutoCreateRowSorter(true);
		spTabReservaServico.setViewportView(tabServico);

		JLabel lblQtdReservaServico = new JLabel("Quantidade");
		lblQtdReservaServico.setBounds(30, 490, 73, 16);
		painelPrincipalAdm.add(lblQtdReservaServico);

		ftxtQtdReservaServico = new JFormattedTextField((Format) null);
		ftxtQtdReservaServico.setBackground(SystemColor.window);
		ftxtQtdReservaServico.setHorizontalAlignment(SwingConstants.CENTER);
		ftxtQtdReservaServico.setEditable(false);
		ftxtQtdReservaServico.setColumns(10);
		ftxtQtdReservaServico.setBounds(111, 485, 58, 28);
		painelPrincipalAdm.add(ftxtQtdReservaServico);

		JLabel lblVlrReservaServico = new JLabel("Total Geral");
		lblVlrReservaServico.setBounds(192, 490, 73, 16);
		painelPrincipalAdm.add(lblVlrReservaServico);

		maskValor = new DecimalFormat("R$ #,###,##0.00");
		NumberFormatter totalServico = new NumberFormatter(maskValor);
		totalServico.setFormat(maskValor);
		totalServico.setAllowsInvalid(false);
		ftxtVlrReservaServico = new JFormattedTextField(maskValor);
		ftxtVlrReservaServico.setBackground(SystemColor.window);
		ftxtVlrReservaServico.setHorizontalAlignment(SwingConstants.RIGHT);
		ftxtVlrReservaServico.setEditable(false);
		ftxtVlrReservaServico.setBounds(264, 485, 98, 28);
		ftxtVlrReservaServico.setColumns(10);
		painelPrincipalAdm.add(ftxtVlrReservaServico);

		lblVersao = new JLabel( versao );
		lblVersao.setBounds(33, 680, 97, 16);
		lblVersao.setEnabled(false);
		painel.add(lblVersao);

		JLabel lblFundo = new JLabel();
		lblFundo.setBounds(0, 0, 1024, 710);
		lblFundo.setIcon(new ImageIcon(fundo.getImage().getScaledInstance(lblFundo.getWidth(), 
				lblFundo.getHeight(), Image.SCALE_DEFAULT)));
		painel.add(lblFundo);

		PrincipalCtrl ctrl = new PrincipalCtrl(
				this,
				tabContainer, 
				painelPrincipal,
				painelChale,
				painelLazer,
				painelServico,
				painelReserva,
				painelContato,
				painelPrincipalAdm, 
				painelReservaAdm, 
				painelChaleAdm, 
				painelServicoAdm, 
				pwdSenha,
				lblLogin,
				lblPwd,
				lblMsg,
				lblRelogio,
				lblPrincipalImg,
				lblChaleImg, 
				lblLazerImg,
				lblServicoImg,
				lblReservaImg,
				lblReservaMsg,
				lblContatoMsg, 
				lblVersao,
				txtLogin, 
				txtPesquisa,
				txtReservaQtdAdulto, 
				txtReservaQtdCrianca, 
				txtReservaNome, 
				txtReservaDocNum, 
				txtReservaEmail, 
				txtReservaTelefone, 
				txtReservaCelular, 
				txtReservaCidade, 
				txtReservaEstado, 
				txtReservaPais, 
				txtContatoNome, 
				txtContatoEmail, 
				txtContatoTelefone, 
				txtContatoCidade, 
				txtContatoEstado, 
				txtContatoPais,  
				ftxtReservaDtInicio, 
				ftxtReservaDtFim, 
				ftxtQtdReservaChale,
				ftxtVlrChale,
				ftxtQtdReservaServico,
				ftxtVlrReservaServico,
				txtaPrincipalInfo,
				txtaPrincipalDetalhe,
				txtaChaleInfo,
				txtaChaleDetalhe,
				txtaLazerInfo,
				txtaLazerDetalhe,
				txtaServicoInfo,
				txtaServicoDetalhe,
				txtaReservaInfo,
				txtaReservaMsg,
				txtaContatoInfo,
				txtaContatoMsg,
				cboReservaCategoria,
				cboReservaDocTipo,
				cboContatoAssunto,
				tabReserva,
				tabServico,
				btnLogin,
				btnReservas,
				btnReservaEnviar,
				btnContatoEnviar,
				btnPesquisar,
				btnReservaLimpar,
				btnContatoLimpar
				);

		txtLogin.addKeyListener( ctrl.teclas );
		pwdSenha.addActionListener( ctrl.acionar );
		btnLogin.addActionListener( ctrl.acionar );
		btnReservas.addActionListener( ctrl.acionar );

		txtReservaNome.addKeyListener( ctrl.teclas );
		txtReservaCidade.addKeyListener( ctrl.teclas );
		txtReservaEstado.addKeyListener( ctrl.teclas );
		txtReservaPais.addKeyListener( ctrl.teclas );
		txtReservaQtdAdulto.addKeyListener( ctrl.teclas );
		txtReservaQtdCrianca.addKeyListener( ctrl.teclas );
		txtaReservaMsg.addKeyListener( ctrl.teclas );
		btnReservaLimpar.addActionListener( ctrl.acionar );
		btnReservaEnviar.addActionListener( ctrl.acionar );

		txtContatoNome.addKeyListener( ctrl.teclas );
		txtContatoCidade.addKeyListener( ctrl.teclas );
		txtContatoEstado.addKeyListener( ctrl.teclas );
		txtContatoPais.addKeyListener( ctrl.teclas);
		txtaContatoMsg.addKeyListener( ctrl.teclas );
		cboReservaCategoria.addActionListener( ctrl.acionar );
		btnContatoLimpar.addActionListener( ctrl.acionar );
		btnContatoEnviar.addActionListener( ctrl.acionar );

		btnPesquisar.addActionListener( ctrl.acionar );
		tabReserva.addMouseListener( ctrl.clicar );
		tabReserva.addKeyListener( ctrl.teclas );
		tabServico.addMouseListener( ctrl.clicar );
	}
}
<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Mail extends CI_Controller {

	public function __construct()
	{
		parent::__construct();
		$this->load->model('MailSend_model');
	}
	
	public function index()
	{
		/*$this->load->library('email');
		$config = Array(
			'protocol' => 'No',
			'smtp_host' => 'smtp.gmail.com',
			'smtp_port' => 465, 
			'smtp_user' => 'akaltest8@gmail.com',
			'smtp_pass' => 'test@1234',
			'smtp_timeout' => '20',
			'mailtype'  => 'html', 
			'charset'   => 'iso-8859-1'
		);
		$config['newline'] = "\r\n";
		$config['crlf'] = "\r\n";
		
		$this->email->initialize($config);
		$this->email->from('akaltest8@gmail.com', 'Admin');
		$this->email->to("shiv.kumar@akalinfosys.com");
		$this->email->subject("Test");
		$this->email->message("Test");
		
		//$status = $this->email->send();
		
		if($this->email->send())
    	{
        	echo 'Your email was sent successfully';
		}else
    	{
        	show_error($this->email->print_debugger());
    	} */
		$EMAIL = "ashutosh.rai@akalinfosys.com";
		//echo "<pre>";print_r($EMAIL);die;
		$subject = 'Trai Dashboard ';
		$body = '<html><body>';
		$body .= "<h2>Dear Ashutosh Rai</h2>";
		$body .= '<p>Test mail </p>';
		$body .= '</body></html>';			
		//echo "<pre>";print_r($body);die;
		$result = $this->MailSend_model->send(array(), array($EMAIL => $EMAIL), $subject, $body);
		echo "<pre>";print_r($result);die;


		die;
	}
	
	
	
	
}

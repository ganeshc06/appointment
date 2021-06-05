package com.hindusabha.appointment.sms;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class Sender {

	// Username that is to be used for submission
	String username;
	// password that is to be used along with username
	String password;
	// Message content that is to be transmitted
	String message;
	String destination;
	// Sender Id to be used for submitting the message
	String SenderId;

	public Sender(String username, String password, String message, String destination, String senderid) {
		this.username = username;
		this.password = password;
		this.message = message;
		this.destination = destination;
		this.SenderId = senderid;
	}

	public void submitMessage() {
		try {
			// Url that will be called to submit the message
			URL sendUrl = new URL("http://trans.dreamztechnolgy.org/smsstatuswithid.aspx");
			HttpURLConnection httpConnection = (HttpURLConnection) sendUrl.openConnection();
			// This method sets the method type to POST so that will be send as a POST request.
			httpConnection.setRequestMethod("POST");
			// This method is set as true wince we intend to send input to the server.
			httpConnection.setDoInput(true);
			// This method implies that we intend to receive data from server.
			httpConnection.setDoOutput(true);
			// Implies do not use cached data
			httpConnection.setUseCaches(false);
			// Data that will be sent over the stream to the server.
			DataOutputStream dataStreamToServer = new DataOutputStream(httpConnection.getOutputStream());
			dataStreamToServer.writeBytes("mobile=" + URLEncoder.encode(this.username, "UTF-8") + "&pass="
					+ URLEncoder.encode(this.password, "UTF-8") + "&senderid="
					+ URLEncoder.encode(this.SenderId, "UTF-8") + "&to=" + URLEncoder.encode(this.destination, "UTF-8")
					+ "&msg=" + URLEncoder.encode(this.message, "UTF-8"));
			dataStreamToServer.flush();
			dataStreamToServer.close();
			// Here take the output value of the server.
			BufferedReader dataStreamFromUrl = new BufferedReader(
					new InputStreamReader(httpConnection.getInputStream()));
			String dataFromUrl = "", dataBuffer = "";
			// Writing information from the stream to the buffer
			while ((dataBuffer = dataStreamFromUrl.readLine()) != null) {
				dataFromUrl += dataBuffer;
			}
			/**
			 * Now dataFromUrl variable contains the Response received from the server so we
			 * can parse the response and process it accordingly.
			 */
			dataStreamFromUrl.close();
			System.out.println("Response: " + dataFromUrl);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		try {
			// Below example is for sending Plain text
			Sender s = new Sender("9987969980", "Dreamz@11", "Test Msg", "9768665939", "TSTMSG");
			s.submitMessage();
		} catch (Exception ex) {
		}
	}
}

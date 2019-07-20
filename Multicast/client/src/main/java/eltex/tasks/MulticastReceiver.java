package eltex.tasks;

import java.net.*;
import java.io.IOException;

public class MulticastReceiver extends Thread {

	protected static MulticastSocket socket = null;
	protected static byte[] buf = new byte[256];

	public static void main(String[] args) throws IOException  {
		
		socket = new MulticastSocket(4446);
		InetAddress group = InetAddress.getByName("230.0.0.0");
		socket.joinGroup(group);

		while (true) {
			DatagramPacket packet = new DatagramPacket(buf, buf.length);
			socket.receive(packet);
			String received = new String(packet.getData(), 0, packet.getLength());
			if ("end".equals(received)) {
				break;
			}
			System.out.println("Received from: " + packet.getAddress () + ":" + packet.getPort ());
		}
		socket.leaveGroup(group);
		socket.close();
	}
}
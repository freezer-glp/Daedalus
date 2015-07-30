package dockercontroller.daedalus.util;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

import org.apache.log4j.Logger;


public class SystemUtil {
	private static Logger logger = Logger.getLogger(SystemUtil.class);
	
	public static String getIpV4() {
		try {
			Enumeration<NetworkInterface> netEnumeration = NetworkInterface.getNetworkInterfaces();
			while(netEnumeration.hasMoreElements()) {
				NetworkInterface ni = (NetworkInterface) netEnumeration.nextElement();
				if (ni.getName().equals("eth0")) {
					Enumeration<InetAddress> e2 = ni.getInetAddresses();
					while (e2.hasMoreElements()) {
						InetAddress ia = (InetAddress) e2.nextElement();
						if (ia instanceof Inet4Address) {
							return ia.getHostAddress();
						}
					}
				}
			}
		} catch (Exception e) {
			logger.error("can.t get host's IP");
			e.printStackTrace();
		}
		return null;
	}
}

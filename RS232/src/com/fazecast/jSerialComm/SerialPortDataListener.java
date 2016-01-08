/*
 * SerialPortDataListener.java
 *
 *       Created on:  Feb 25, 2015
 *  Last Updated on:  Mar 12, 2015
 *           Author:  Will Hedgecock
 *
 * Copyright (C) 2012-2015 Fazecast, Inc.
 *
 * This file is part of jSerialComm.
 *
 * jSerialComm is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * jSerialComm is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with jSerialComm.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.fazecast.jSerialComm;

import java.util.EventListener;

/**
 * This interface must be implemented to enable simple event-based serial port I/O.
 * 
 * @author Will Hedgecock &lt;will.hedgecock@fazecast.com&gt;
 * @version 1.3.11
 * @see java.util.EventListener
 */
public interface SerialPortDataListener extends EventListener
{
	/**
	 * Must be overridden to return one or more desired event constants for which the {@link #serialEvent(SerialPortEvent)} callback should be triggered.
	 * <p>
	 * Valid event constants are:
	 * <p>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{@link SerialPort#LISTENING_EVENT_DATA_AVAILABLE}<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{@link SerialPort#LISTENING_EVENT_DATA_RECEIVED}<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{@link SerialPort#LISTENING_EVENT_DATA_WRITTEN}<br>
	 * <p>
	 * If you choose to listen for the {@link SerialPort#LISTENING_EVENT_DATA_RECEIVED} event, you should implement the sub-interface {@link SerialPortPacketListener} instead of this one.
	 * <p>
	 * Two or more events may be OR'd together to listen for multiple events; however, if {@link SerialPort#LISTENING_EVENT_DATA_AVAILABLE} is OR'd with {@link SerialPort#LISTENING_EVENT_DATA_RECEIVED}, the {@link SerialPort#LISTENING_EVENT_DATA_RECEIVED} flag will take precedence.
	 * <p>
	 * Note that event-based <i>write</i> callbacks are only supported on Windows operating systems. As such, the {@link SerialPort#LISTENING_EVENT_DATA_WRITTEN}
	 * event will never be called on a non-Windows system.
	 * 
	 * @return The event constants that should trigger the {@link #serialEvent(SerialPortEvent)} callback.
	 * @see SerialPort#LISTENING_EVENT_DATA_AVAILABLE
	 * @see SerialPort#LISTENING_EVENT_DATA_RECEIVED
	 * @see SerialPort#LISTENING_EVENT_DATA_WRITTEN
	 */
	public abstract int getListeningEvents();
	
	/**
	 * Called whenever one of the serial port events specified by the {@link #getListeningEvents()} method occurs.
	 * 
	 * @param event A {@link SerialPortEvent} object containing information and/or data about the serial event that occurred.
	 * @see SerialPortEvent
	 */
	public abstract void serialEvent(SerialPortEvent event);
}

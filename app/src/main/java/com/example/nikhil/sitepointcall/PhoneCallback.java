package com.example.nikhil.sitepointcall;

/**
 * Created by NIKHIL on 12-03-2018.
 */

import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.TelephonyManager;
import android.widget.TextView;

/**
 * PhoneCallback.java.
 *
 * @author Rodrigo Cericatto
 * @since Nov 19, 2016
 */
public class PhoneCallback extends PhoneStateListener {

    //--------------------------------------------------
    // Constants
    //--------------------------------------------------

    public static final String LOG_TAG = "PhoneCallback";

    //--------------------------------------------------
    // Attributes
    //--------------------------------------------------

    private final TextView mTextView;

    //--------------------------------------------------
    // Constructor
    //--------------------------------------------------

    public PhoneCallback(TextView textView) {
        mTextView = textView;
    }

    //--------------------------------------------------
    // Methods
    //--------------------------------------------------

    private String serviceStateToString(int serviceState) {
        switch (serviceState) {
            case ServiceState.STATE_IN_SERVICE:
                return "STATE_IN_SERVICE";
            case ServiceState.STATE_OUT_OF_SERVICE:
                return "STATE_OUT_OF_SERVICE";
            case ServiceState.STATE_EMERGENCY_ONLY:
                return "STATE_EMERGENCY_ONLY";
            case ServiceState.STATE_POWER_OFF:
                return "STATE_POWER_OFF";
            default:
                return "UNKNOWN_STATE";
        }
    }

    private String callStateToString(int state) {
        switch (state) {
            case TelephonyManager.CALL_STATE_IDLE:
                return "\nonCallStateChanged: CALL_STATE_IDLE, ";
            case TelephonyManager.CALL_STATE_RINGING:
                return "\nonCallStateChanged: CALL_STATE_RINGING, ";
            case TelephonyManager.CALL_STATE_OFFHOOK:
                return "\nonCallStateChanged: CALL_STATE_OFFHOOK, ";
            default:
                return "\nUNKNOWN_STATE: " + state + ", ";
        }
    }



    @Override
    public void onCallStateChanged(int state, String incomingNumber) {
        super.onCallStateChanged(state, incomingNumber);
        callStateToString(state);
        String message = callStateToString(state) + "incomingNumber: " + incomingNumber;
        mTextView.setText(message);
    }




}
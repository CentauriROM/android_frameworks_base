/*
 * Copyright (C) 2014 CentauriROM
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.systemui.quicksettings;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;

import com.android.internal.util.nameless.NamelessActions;
import com.android.internal.util.nameless.NamelessUtils;
import com.android.systemui.R;
import com.android.systemui.nameless.onthego.OnTheGoDialog;
import com.android.systemui.statusbar.phone.QuickSettingsController;
import com.android.systemui.statusbar.phone.QuickSettingsContainerView;

public class OnTheGoTile extends QuickSettingsTile {

    private static final int CAMERA_BACK  = 0;
    private static final int CAMERA_FRONT = 1;

    public OnTheGoTile(final Context context, final QuickSettingsController qsc) {
        super(context, qsc);

        mOnClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NamelessActions.processAction(mContext, NamelessActions.ACTION_ONTHEGO_TOGGLE);
            }
        };

        mOnLongClick = new OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                new OnTheGoDialog(mContext).show();
                return true;
            }
        };

        qsc.registerObservedContent(Settings.System.getUriFor(
                Settings.System.ON_THE_GO_CAMERA), this);
    }

    @Override
    void onPostCreate() {
        updateTile();
        super.onPostCreate();
    }

    @Override
    public void updateResources() {
        updateTile();
        super.updateResources();
    }

    private void toggleCamera() {
        final ContentResolver resolver = mContext.getContentResolver();
        final int camera = Settings.System.getInt(resolver,
                Settings.System.ON_THE_GO_CAMERA,
                CAMERA_BACK);

        int newValue;
        if (camera == CAMERA_BACK) {
            newValue = CAMERA_FRONT;
        } else {
            newValue = CAMERA_BACK;
        }

        Settings.System.putInt(resolver,
                Settings.System.ON_THE_GO_CAMERA,
                newValue);

        updateResources();
    }

    @Override
    public void onChangeUri(ContentResolver resolver, Uri uri) {
        updateResources();
    }

    private synchronized void updateTile() {

        int cameraMode;

        if (NamelessUtils.hasFrontCamera(mContext)) {
            cameraMode = Settings.System.getInt(mContext.getContentResolver(),
                    Settings.System.ON_THE_GO_CAMERA,
                    CAMERA_BACK);
        } else {
            cameraMode = CAMERA_BACK;
        }

        switch (cameraMode) {
            default:
            case CAMERA_BACK:
                mLabel = mContext.getString(R.string.quick_settings_onthego_back);
                mDrawable = R.drawable.ic_qs_onthego;
                break;
            case CAMERA_FRONT:
                mLabel = mContext.getString(R.string.quick_settings_onthego_front);
                mDrawable = R.drawable.ic_qs_onthego_front;
                break;
        }

    }

}

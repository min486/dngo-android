package com.min.dnapp.presentation.find.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.min.dnapp.presentation.ui.icon.AppIcons
import com.min.dnapp.presentation.ui.icon.appicons.RecordBest
import com.min.dnapp.presentation.ui.icon.appicons.RecordBookmark
import com.min.dnapp.presentation.ui.icon.appicons.RecordComment
import com.min.dnapp.presentation.ui.icon.appicons.RecordLike
import com.min.dnapp.presentation.ui.icon.appicons.RecordSurprise
import com.min.dnapp.presentation.ui.theme.MomentoTheme

@Composable
fun FindReactionIconSection(
    bestNum: Int,
    likeNum: Int,
    surpriseNum: Int,
    commentNum: Int
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = AppIcons.RecordBest,
                    contentDescription = null,
                    tint = MomentoTheme.colors.grayW60
                )
                Spacer(Modifier.width(2.dp))
                Text(
                    text = bestNum.toString(),
                    style = MomentoTheme.typography.body01,
                    color = MomentoTheme.colors.grayW20
                )
            }

            Spacer(Modifier.width(4.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = AppIcons.RecordLike,
                    contentDescription = null,
                    tint = MomentoTheme.colors.grayW60
                )
                Spacer(Modifier.width(2.dp))
                Text(
                    text = likeNum.toString(),
                    style = MomentoTheme.typography.body01,
                    color = MomentoTheme.colors.grayW20
                )
            }

            Spacer(Modifier.width(4.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = AppIcons.RecordSurprise,
                    contentDescription = null,
                    tint = MomentoTheme.colors.grayW60
                )
                Spacer(Modifier.width(2.dp))
                Text(
                    text = surpriseNum.toString(),
                    style = MomentoTheme.typography.body01,
                    color = MomentoTheme.colors.grayW20
                )
            }
        }

        Row(
            modifier = Modifier.clickable {  },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = AppIcons.RecordComment,
                    contentDescription = null,
                    tint = MomentoTheme.colors.grayW60
                )
                Spacer(Modifier.width(2.dp))
                Text(
                    text = commentNum.toString(),
                    style = MomentoTheme.typography.body01,
                    color = MomentoTheme.colors.grayW20
                )
            }

            Spacer(Modifier.width(12.dp))

            Icon(
                imageVector = AppIcons.RecordBookmark,
                contentDescription = null,
                tint = MomentoTheme.colors.grayW60
            )
        }
    }
}

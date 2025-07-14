package com.example.rickandmorty.feature.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun FilterBottomSheetContent(
    currentStatus: String?,
    currentGender: String?,
    onApply: (String?, String?) -> Unit,
    onClear: () -> Unit
) {
    val statusOptions = listOf("Alive", "Dead", "unknown")
    val genderOptions = listOf("Male", "Female", "Genderless", "unknown")

    var selectedStatus by rememberSaveable { mutableStateOf(currentStatus) }
    var selectedGender by rememberSaveable { mutableStateOf(currentGender) }

    Column(Modifier.padding(16.dp)) {
        Text("Status", fontWeight = FontWeight.Bold)
        statusOptions.forEach { status ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { selectedStatus = status }
                    .padding(8.dp)
            ) {
                RadioButton(
                    selected = selectedStatus == status,
                    onClick = { selectedStatus = status }
                )
                Text(text = status, modifier = Modifier.padding(start = 8.dp))
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("Gender", fontWeight = FontWeight.Bold)
        genderOptions.forEach { gender ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { selectedGender = gender }
                    .padding(8.dp)
            ) {
                RadioButton(
                    selected = selectedGender == gender,
                    onClick = { selectedGender = gender }
                )
                Text(text = gender, modifier = Modifier.padding(start = 8.dp))
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            OutlinedButton(onClick = onClear) {
                Text("Clear")
            }

            Button(onClick = { onApply(selectedStatus, selectedGender) }) {
                Text("Apply")
            }
        }
    }
}


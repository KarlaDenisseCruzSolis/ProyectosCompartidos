/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.reply.ui

import com.example.reply.data.Email
import com.example.reply.data.MailboxType
import com.example.reply.data.local.LocalEmailsDataProvider

data class ReplyUiState(
    val mailboxes: Map<MailboxType, List<Email>> = emptyMap(),
    val currentMailbox: MailboxType = MailboxType.Inbox,
    val currentSelectedEmail: Email = LocalEmailsDataProvider.defaultEmail,
    val isShowingHomepage: Boolean = true
) {
    /**
     * Una propiedad calculada que devuelve la lista de correos electrónicos para el [currentMailbox] actual.
     * Esta propiedad se inicializa de forma perezosa (`lazy`), lo que significa que su valor
     * se calcula solo la primera vez que se accede a ella y luego se reutiliza.
     * El `!!` asegura que siempre habrá una lista, asumiendo que `mailboxes` siempre contendrá
     * una entrada para el `currentMailbox`.
     */
    val currentMailboxEmails: List<Email> by lazy { mailboxes[currentMailbox]!! }
}

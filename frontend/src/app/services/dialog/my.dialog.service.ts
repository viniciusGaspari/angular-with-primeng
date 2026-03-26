import { DynamicDialogRef, DialogService } from 'primeng/dynamicdialog'; // Removi o Config
import { inject, Injectable } from '@angular/core';
import { DialogLoadingComponent } from '../../component/dialogs/dialog.loading/dialog.loading.component';

@Injectable({providedIn: 'root'})
export class MyDialogService {
    
    private dialogService = inject(DialogService);
    
    dialogRef: DynamicDialogRef<any> | undefined | null;
    
    showLoading(): void {
        this.dialogRef = this.dialogService.open(DialogLoadingComponent, {
            closable: false,
            showHeader: false,
            dismissableMask: false,
            styleClass: 'loading-dialog-custom'
        });

    }

    onCloseDialog(): void {
        setTimeout(() => {
            this.dialogRef?.close();
        }, 3500)
    }
}
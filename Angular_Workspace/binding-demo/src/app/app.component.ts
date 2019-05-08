import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  title = 'binding-demo';
  rating = 3.2;
  starWidth = this.rating*75/5;
  starColor = "yellow";
  customerName = "Alex";

  performAction(): void{
    alert("Button is clicked..");
    this.title = "Binding-demo-in-angular";
  }
}

export class PromoCode {
  codeId: string;
  code: string;
  image: string;
  description: string;
  amount: number;

  constructor(
    codeId: string,
    code: string,
    image: string,
    description: string,
    amount: number
  ) {
    this.codeId = codeId;
    this.code = code;
    this.image = image;
    this.description = description;
    this.amount = amount;
  }
}

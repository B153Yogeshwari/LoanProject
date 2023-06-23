package com.cjc.carloan.serviceImpl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.carloan.enums.CustomerLoanStatus;
import com.cjc.carloan.exception.PdfNotGenerated;
import com.cjc.carloan.model.CustomerDetails;
import com.cjc.carloan.model.SanctionLetter;
import com.cjc.carloan.repository.CustomerRepository;
import com.cjc.carloan.serviceI.SanctionService;
import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;


@Service
public class SanctionServiceImpl implements SanctionService  
{
    @Autowired
	CustomerRepository cr;
	
	@Override
	public Iterable<CustomerDetails> getCustomerbyStatus(String customerLoanStatus)
	{
		Iterable<CustomerDetails> get = cr.findAllByCustomerLoanStatus(customerLoanStatus);
		return get;
		
	}

	@Override
	public ByteArrayInputStream generateSactionId(Integer customerId, SanctionLetter sanctionLetter) {
		
		
		Optional<CustomerDetails> customerdetails = cr.findById(customerId);
		CustomerDetails customerdetails1 = customerdetails.get();
		
		if(customerdetails.isPresent()) {
			customerdetails1.setCustomerLoanStatus(String.valueOf(CustomerLoanStatus.SanctionLetterGenerated));
			customerdetails1.getSanctionletter().setSanctionDate(sanctionLetter.getSanctionDate());
			customerdetails1.getSanctionletter().setApplicantName(sanctionLetter.getApplicantName());
			customerdetails1.getSanctionletter().setLoanAmountSanctioned(sanctionLetter.getLoanAmountSanctioned());
			customerdetails1.getSanctionletter().setRateOfInterest(sanctionLetter.getRateOfInterest());
			customerdetails1.getSanctionletter().setLoanTenure(sanctionLetter.getLoanTenure());
			customerdetails1.getSanctionletter().setMonthlyEmiAmount(sanctionLetter.getMonthlyEmiAmount());
			customerdetails1.getSanctionletter().setTermsAndCondition(sanctionLetter.getTermsAndCondition());
			customerdetails1.getSanctionletter().setSanctionLetter(sanctionLetter.getSanctionLetter());
			
		
			
			String title = "ApnaCarLoan Finance Ltd.";
		
			Document document = new Document(PageSize.A4);
	
			String content1 = "\n\n Dear " + customerdetails1.getCustomerFirstName()
			+ ","
			+ "\nApnaCarLoan Finance Ltd. is Happy to informed you that your car loan application has been approved. ";

	String content2 = "\n\nWe hope that you find the terms and conditions of this loan satisfactory "
			+ "and that it will help you meet your financial needs.\n\nIf you have any questions or need any assistance regarding your loan, "
			+ "please do not hesitate to contact us.\n\nWe wish you all the best and thank you for choosing us."
			+ "\n\nSincerely,\n\n" + "Mr.D.Borade (Credit Manager)";
							
	
	       ByteArrayOutputStream opt = new ByteArrayOutputStream();
	     
	       PdfWriter.getInstance(document, opt);
			document.open();
	       
			
			Image img = null;
			try {
				img = Image.getInstance("D:\\pravin img.jpg");
				img.scalePercent(50, 50);
				img.setAlignment(Element.ALIGN_RIGHT);
				document.add(img);

			} catch (BadElementException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			Font titlefont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 25);
			Paragraph titlepara = new Paragraph(title, titlefont);
			titlepara.setAlignment(Element.ALIGN_CENTER);
			document.add(titlepara);
		
			Font titlefont2 = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10);
			Paragraph paracontent1 = new Paragraph(content1, titlefont2);
			document.add(paracontent1);
		
			PdfPTable table = new PdfPTable(2);
			table.setWidthPercentage(100f);
			table.setWidths(new int[] { 2, 2 });
			table.setSpacingBefore(10);

			PdfPCell cell = new PdfPCell();
			cell.setBackgroundColor(CMYKColor.WHITE);
			cell.setPadding(5);

			Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			font.setColor(5, 5, 161);

			Font font1 = FontFactory.getFont(FontFactory.HELVETICA);
			font.setColor(5, 5, 161);

			cell.setPhrase(new Phrase("Loan amount Sanctioned", font));
			table.addCell(cell);

			cell.setPhrase(new Phrase(String.valueOf("₹ " + customerdetails1.getSanctionletter().getLoanAmountSanctioned()),
					font1));
			table.addCell(cell);

			cell.setPhrase(new Phrase("loan tenure", font));
			table.addCell(cell);

			cell.setPhrase(new Phrase(String.valueOf(customerdetails1.getSanctionletter().getLoanTenure()), font1));
			table.addCell(cell);

			cell.setPhrase(new Phrase("interest rate", font));
			table.addCell(cell);

			cell.setPhrase(
					new Phrase(String.valueOf(customerdetails1.getSanctionletter().getRateOfInterest()) + " %", font1));
			table.addCell(cell);

			cell.setPhrase(new Phrase("Sanction letter generated Date", font));
			table.addCell(cell);

			Date date = new Date();
			String curdate = date.toString();
			customerdetails1.getSanctionletter().setSanctionDate(curdate);
			cell.setPhrase(
					new Phrase(String.valueOf(customerdetails1.getSanctionletter().getSanctionDate()), font1));
			table.addCell(cell);

			cell.setPhrase(new Phrase("Total loan Amount with Intrest", font));
			table.addCell(cell);

			document.add(table);

			Font titlefont3 = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10);
			Paragraph paracontent2 = new Paragraph(content2, titlefont3);
			document.add(paracontent2);
			document.close();
			
			ByteArrayInputStream byt = new ByteArrayInputStream(opt.toByteArray());
			byte[] bytes = byt.readAllBytes();
			customerdetails1.getSanctionletter().setSanctionLetter(bytes);
	    CustomerDetails ss=cr.save(customerdetails1);
			return byt;
		}
		else 
		{
			throw new PdfNotGenerated("PDF File Not Genarated");
		}
	 
	}

}

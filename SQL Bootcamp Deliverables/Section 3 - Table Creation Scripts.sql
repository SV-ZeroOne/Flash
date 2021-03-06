USE [SquareEyes]
GO
/****** Object:  Table [dbo].[CustomerAccounts]    Script Date: 2017/01/29 5:55:12 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CustomerAccounts](
	[CustomerID] [int] IDENTITY(1,1) NOT NULL,
	[FirstName] [varchar](50) NOT NULL,
	[Surname] [varchar](50) NOT NULL,
	[Email] [varchar](320) NOT NULL,
	[Phone] [varchar](10) NULL,
	[Password] [char](128) NOT NULL,
 CONSTRAINT [PK_CustomerAccounts_1] PRIMARY KEY CLUSTERED 
(
	[CustomerID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[CustomerAddress]    Script Date: 2017/01/29 5:55:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CustomerAddress](
	[CustomerAddressID] [int] IDENTITY(1,1) NOT NULL,
	[CustomerID] [int] NOT NULL,
	[Address1] [varchar](100) NOT NULL,
	[Address2] [varchar](100) NULL,
	[Suburb] [varchar](100) NULL,
	[City] [varchar](100) NULL,
	[PostalCode] [varchar](4) NULL,
	[AddressType] [varchar](20) NULL,
 CONSTRAINT [PK_CustomerAddress] PRIMARY KEY CLUSTERED 
(
	[CustomerAddressID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[CustomerOrders]    Script Date: 2017/01/29 5:55:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CustomerOrders](
	[CustomerOrderID] [int] IDENTITY(1,1) NOT NULL,
	[OrderAmount] [numeric](8, 2) NULL,
	[OrderDate] [datetime] NULL,
	[OrderReference] [varchar](50) NOT NULL,
	[OrderAddress1] [varchar](100) NOT NULL,
	[OrderAddress2] [varchar](100) NULL,
	[OrderSuburb] [varchar](50) NULL,
	[OrderCity] [varchar](50) NOT NULL,
	[OrderPostalCode] [varchar](4) NOT NULL,
	[OrderPhone] [varchar](10) NULL,
	[OrderEmail] [varchar](320) NOT NULL,
	[OrderShippedDate] [datetime] NULL,
	[OrderTrackingNumber] [varchar](50) NULL,
	[OrderDeliveryMethod] [varchar](50) NOT NULL,
	[OrderStatus] [varchar](20) NULL,
	[CustomerID] [int] NOT NULL,
	[VoucherID] [int] NULL,
 CONSTRAINT [PK_CustomerOrders] PRIMARY KEY CLUSTERED 
(
	[CustomerOrderID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Invoice]    Script Date: 2017/01/29 5:55:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Invoice](
	[InvoiceID] [int] IDENTITY(1,1) NOT NULL,
	[InvoiceNumber] [varchar](50) NOT NULL,
	[TotalAmount] [numeric](8, 2) NOT NULL,
	[Date] [datetime] NULL,
	[CustomerOrderID] [int] NOT NULL,
 CONSTRAINT [PK_Invoice] PRIMARY KEY CLUSTERED 
(
	[InvoiceID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[OrderDetails]    Script Date: 2017/01/29 5:55:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[OrderDetails](
	[DetailD] [int] IDENTITY(1,1) NOT NULL,
	[DetailQuantity] [smallint] NOT NULL,
	[CustomerOrderID] [int] NOT NULL,
	[StockReferenceID] [int] NOT NULL,
 CONSTRAINT [PK_OrderDetails] PRIMARY KEY CLUSTERED 
(
	[DetailD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ShoppingCart]    Script Date: 2017/01/29 5:55:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ShoppingCart](
	[ShoppingCartID] [int] IDENTITY(1,1) NOT NULL,
	[Quantity] [smallint] NOT NULL,
	[CustomerID] [int] NOT NULL,
	[StockReferenceID] [int] NOT NULL,
 CONSTRAINT [PK_ShoppingCart] PRIMARY KEY CLUSTERED 
(
	[ShoppingCartID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Vouchers]    Script Date: 2017/01/29 5:55:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Vouchers](
	[VoucherID] [int] IDENTITY(1,1) NOT NULL,
	[Amount] [numeric](8, 2) NOT NULL,
	[Code] [varchar](50) NOT NULL,
	[DateIssued] [datetime] NOT NULL,
	[Valid] [bit] NOT NULL,
 CONSTRAINT [PK_Vouchers] PRIMARY KEY CLUSTERED 
(
	[VoucherID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
ALTER TABLE [dbo].[CustomerAddress]  WITH CHECK ADD  CONSTRAINT [FK_CustomerAddress_CustomerAccounts] FOREIGN KEY([CustomerID])
REFERENCES [dbo].[CustomerAccounts] ([CustomerID])
GO
ALTER TABLE [dbo].[CustomerAddress] CHECK CONSTRAINT [FK_CustomerAddress_CustomerAccounts]
GO
ALTER TABLE [dbo].[CustomerOrders]  WITH CHECK ADD  CONSTRAINT [FK_CustomerOrders_CustomerAccounts] FOREIGN KEY([CustomerID])
REFERENCES [dbo].[CustomerAccounts] ([CustomerID])
GO
ALTER TABLE [dbo].[CustomerOrders] CHECK CONSTRAINT [FK_CustomerOrders_CustomerAccounts]
GO
ALTER TABLE [dbo].[CustomerOrders]  WITH CHECK ADD  CONSTRAINT [FK_CustomerOrders_Vouchers] FOREIGN KEY([VoucherID])
REFERENCES [dbo].[Vouchers] ([VoucherID])
GO
ALTER TABLE [dbo].[CustomerOrders] CHECK CONSTRAINT [FK_CustomerOrders_Vouchers]
GO
ALTER TABLE [dbo].[Invoice]  WITH CHECK ADD  CONSTRAINT [FK_Invoice_CustomerOrders] FOREIGN KEY([CustomerOrderID])
REFERENCES [dbo].[CustomerOrders] ([CustomerOrderID])
GO
ALTER TABLE [dbo].[Invoice] CHECK CONSTRAINT [FK_Invoice_CustomerOrders]
GO
ALTER TABLE [dbo].[OrderDetails]  WITH CHECK ADD  CONSTRAINT [FK_OrderDetails_CustomerOrders] FOREIGN KEY([CustomerOrderID])
REFERENCES [dbo].[CustomerOrders] ([CustomerOrderID])
GO
ALTER TABLE [dbo].[OrderDetails] CHECK CONSTRAINT [FK_OrderDetails_CustomerOrders]
GO
ALTER TABLE [dbo].[OrderDetails]  WITH CHECK ADD  CONSTRAINT [FK_OrderDetails_Stock] FOREIGN KEY([StockReferenceID])
REFERENCES [dbo].[Stock] ([StockReferenceID])
GO
ALTER TABLE [dbo].[OrderDetails] CHECK CONSTRAINT [FK_OrderDetails_Stock]
GO
ALTER TABLE [dbo].[ShoppingCart]  WITH CHECK ADD  CONSTRAINT [FK_ShoppingCart_CustomerAccounts] FOREIGN KEY([CustomerID])
REFERENCES [dbo].[CustomerAccounts] ([CustomerID])
GO
ALTER TABLE [dbo].[ShoppingCart] CHECK CONSTRAINT [FK_ShoppingCart_CustomerAccounts]
GO
ALTER TABLE [dbo].[ShoppingCart]  WITH CHECK ADD  CONSTRAINT [FK_ShoppingCart_Stock] FOREIGN KEY([StockReferenceID])
REFERENCES [dbo].[Stock] ([StockReferenceID])
GO
ALTER TABLE [dbo].[ShoppingCart] CHECK CONSTRAINT [FK_ShoppingCart_Stock]
GO
ALTER TABLE [dbo].[CustomerAccounts]  WITH CHECK ADD  CONSTRAINT [EmailConstraint] CHECK  (([Email] like '%@%'))
GO
ALTER TABLE [dbo].[CustomerAccounts] CHECK CONSTRAINT [EmailConstraint]
GO
ALTER TABLE [dbo].[CustomerAccounts]  WITH CHECK ADD  CONSTRAINT [FirstName] CHECK  ((datalength([FirstName])>(0)))
GO
ALTER TABLE [dbo].[CustomerAccounts] CHECK CONSTRAINT [FirstName]
GO
ALTER TABLE [dbo].[CustomerAccounts]  WITH CHECK ADD  CONSTRAINT [Phone] CHECK  ((datalength([Phone])=(10)))
GO
ALTER TABLE [dbo].[CustomerAccounts] CHECK CONSTRAINT [Phone]
GO
ALTER TABLE [dbo].[CustomerAccounts]  WITH CHECK ADD  CONSTRAINT [Surname] CHECK  ((datalength([Surname])>(0)))
GO
ALTER TABLE [dbo].[CustomerAccounts] CHECK CONSTRAINT [Surname]
GO
ALTER TABLE [dbo].[CustomerOrders]  WITH CHECK ADD  CONSTRAINT [OrderAmount] CHECK  (([OrderAmount]>(0)))
GO
ALTER TABLE [dbo].[CustomerOrders] CHECK CONSTRAINT [OrderAmount]
GO
ALTER TABLE [dbo].[CustomerOrders]  WITH CHECK ADD  CONSTRAINT [OrderEmail] CHECK  (([OrderEmail] like '%@%'))
GO
ALTER TABLE [dbo].[CustomerOrders] CHECK CONSTRAINT [OrderEmail]
GO
ALTER TABLE [dbo].[CustomerOrders]  WITH CHECK ADD  CONSTRAINT [OrderPhone] CHECK  ((datalength([OrderPhone])=(10)))
GO
ALTER TABLE [dbo].[CustomerOrders] CHECK CONSTRAINT [OrderPhone]
GO
ALTER TABLE [dbo].[Invoice]  WITH CHECK ADD  CONSTRAINT [TotalAmount] CHECK  (([TotalAmount]>=(0)))
GO
ALTER TABLE [dbo].[Invoice] CHECK CONSTRAINT [TotalAmount]
GO
ALTER TABLE [dbo].[OrderDetails]  WITH CHECK ADD  CONSTRAINT [DetailQuantity] CHECK  (([DetailQuantity]>(0)))
GO
ALTER TABLE [dbo].[OrderDetails] CHECK CONSTRAINT [DetailQuantity]
GO
ALTER TABLE [dbo].[ShoppingCart]  WITH CHECK ADD  CONSTRAINT [Quantity] CHECK  (([Quantity]>(0)))
GO
ALTER TABLE [dbo].[ShoppingCart] CHECK CONSTRAINT [Quantity]
GO
ALTER TABLE [dbo].[Vouchers]  WITH CHECK ADD  CONSTRAINT [Amount] CHECK  (([Amount]>(0)))
GO
ALTER TABLE [dbo].[Vouchers] CHECK CONSTRAINT [Amount]
GO

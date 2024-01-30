package com.lanchonete.lanchonete.LogsEstoque;

import com.lanchonete.lanchonete.GerarId.GerarId;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "logsEstoque")
public class LogsEstoque extends GerarId {
}
